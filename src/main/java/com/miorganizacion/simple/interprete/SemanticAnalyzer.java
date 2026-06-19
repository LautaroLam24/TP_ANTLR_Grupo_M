package com.miorganizacion.simple.interprete;

import java.util.ArrayList;
import java.util.List;

/**
 * PRIMERA PASADA: análisis semántico.
 *
 * Recorre el árbol con el patrón Visitor devolviendo el {@link Type} de cada
 * expresión y acumulando errores. Detecta:
 *   - uso de variables no declaradas;
 *   - redeclaración de variables (en el mismo ámbito);
 *   - incompatibilidades de tipos (declaración, asignación, condiciones);
 *   - operaciones inválidas (p. ej. sumar bool, negar un número);
 *   - división por cero detectable de forma estática (divisor literal 0).
 *
 * Cuando una sub-expresión ya falló se devuelve {@link Type#ERROR} para no
 * encadenar errores en cascada.
 */
public class SemanticAnalyzer extends SimpleBaseVisitor<Type> {

    private final SymbolTable symbols = new SymbolTable();
    private final List<String> errors = new ArrayList<>();

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }

    private void error(int line, String msg) {
        errors.add("[línea " + line + "] " + msg);
    }

    /* ===================== Sentencias ===================== */

    @Override
    public Type visitVarDecl(SimpleParser.VarDeclContext ctx) {
        String name = ctx.ID().getText();
        Type declared = visit(ctx.type());
        int line = ctx.getStart().getLine();

        if (symbols.existsInCurrentScope(name)) {
            error(line, "redeclaración de la variable '" + name + "'");
        }

        Symbol s = symbols.declare(name, declared);

        if (ctx.expression() != null) {
            Type valueType = visit(ctx.expression());
            if (!assignable(declared, valueType)) {
                error(line, "no se puede inicializar '" + name + "' (" + declared
                        + ") con un valor de tipo " + valueType);
            }
            s.setValue(null); // marcado como inicializado a nivel semántico
        }
        return null;
    }

    @Override
    public Type visitAssignment(SimpleParser.AssignmentContext ctx) {
        String name = ctx.ID().getText();
        int line = ctx.getStart().getLine();
        Symbol s = symbols.resolve(name);

        Type valueType = visit(ctx.expression());

        if (s == null) {
            error(line, "variable no declarada: '" + name + "'");
            return null;
        }
        if (!assignable(s.getType(), valueType)) {
            error(line, "no se puede asignar un valor de tipo " + valueType
                    + " a '" + name + "' (" + s.getType() + ")");
        }
        return null;
    }

    @Override
    public Type visitPrintStmt(SimpleParser.PrintStmtContext ctx) {
        visit(ctx.expression()); // cualquier tipo es imprimible
        return null;
    }

    @Override
    public Type visitIfStmt(SimpleParser.IfStmtContext ctx) {
        checkBooleanCondition(ctx.expression(), "if");
        for (SimpleParser.BlockContext b : ctx.block()) {
            visit(b);
        }
        return null;
    }

    @Override
    public Type visitWhileStmt(SimpleParser.WhileStmtContext ctx) {
        checkBooleanCondition(ctx.expression(), "while");
        visit(ctx.block());
        return null;
    }

    @Override
    public Type visitBlock(SimpleParser.BlockContext ctx) {
        symbols.enterScope();
        for (SimpleParser.StatementContext st : ctx.statement()) {
            visit(st);
        }
        symbols.exitScope();
        return null;
    }

    private void checkBooleanCondition(SimpleParser.ExpressionContext cond, String stmt) {
        Type t = visit(cond);
        if (t != Type.BOOL && t != Type.ERROR) {
            error(cond.getStart().getLine(),
                    "la condición del '" + stmt + "' debe ser bool, no " + t);
        }
    }

    /* ===================== Tipos ===================== */

    @Override public Type visitTipoInt(SimpleParser.TipoIntContext ctx)       { return Type.INT; }
    @Override public Type visitTipoReal(SimpleParser.TipoRealContext ctx)     { return Type.REAL; }
    @Override public Type visitTipoString(SimpleParser.TipoStringContext ctx) { return Type.STRING; }
    @Override public Type visitTipoBool(SimpleParser.TipoBoolContext ctx)     { return Type.BOOL; }

    /* ===================== Expresiones ===================== */

    @Override
    public Type visitParenExpr(SimpleParser.ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Type visitUnaryExpr(SimpleParser.UnaryExprContext ctx) {
        Type t = visit(ctx.expression());
        int line = ctx.getStart().getLine();
        if (t == Type.ERROR) return Type.ERROR;

        if (ctx.op.getText().equals("-")) {
            if (t.isNumeric()) return t;
            error(line, "el operador unario '-' requiere un número, no " + t);
        } else { // '!'
            if (t == Type.BOOL) return Type.BOOL;
            error(line, "el operador '!' requiere un bool, no " + t);
        }
        return Type.ERROR;
    }

    @Override
    public Type visitMulDivExpr(SimpleParser.MulDivExprContext ctx) {
        Type l = visit(ctx.left);
        Type r = visit(ctx.right);
        int line = ctx.getStart().getLine();
        if (l == Type.ERROR || r == Type.ERROR) return Type.ERROR;

        if (l.isNumeric() && r.isNumeric()) {
            if (ctx.op.getText().equals("/") && isLiteralZero(ctx.right)) {
                error(line, "división por cero");
            }
            return numericResult(l, r);
        }
        error(line, "la operación '" + ctx.op.getText()
                + "' requiere operandos numéricos (recibió " + l + " y " + r + ")");
        return Type.ERROR;
    }

    @Override
    public Type visitAddSubExpr(SimpleParser.AddSubExprContext ctx) {
        Type l = visit(ctx.left);
        Type r = visit(ctx.right);
        int line = ctx.getStart().getLine();
        if (l == Type.ERROR || r == Type.ERROR) return Type.ERROR;

        if (l.isNumeric() && r.isNumeric()) {
            return numericResult(l, r);
        }
        // El '+' también concatena cadenas
        if (ctx.op.getText().equals("+") && l == Type.STRING && r == Type.STRING) {
            return Type.STRING;
        }
        error(line, "la operación '" + ctx.op.getText()
                + "' no es válida entre " + l + " y " + r);
        return Type.ERROR;
    }

    @Override
    public Type visitRelExpr(SimpleParser.RelExprContext ctx) {
        Type l = visit(ctx.left);
        Type r = visit(ctx.right);
        if (l == Type.ERROR || r == Type.ERROR) return Type.ERROR;

        if (l.isNumeric() && r.isNumeric()) return Type.BOOL;
        error(ctx.getStart().getLine(), "la comparación '" + ctx.op.getText()
                + "' requiere operandos numéricos (recibió " + l + " y " + r + ")");
        return Type.ERROR;
    }

    @Override
    public Type visitEqExpr(SimpleParser.EqExprContext ctx) {
        Type l = visit(ctx.left);
        Type r = visit(ctx.right);
        if (l == Type.ERROR || r == Type.ERROR) return Type.ERROR;

        boolean ok = (l.isNumeric() && r.isNumeric()) || (l == r);
        if (ok) return Type.BOOL;
        error(ctx.getStart().getLine(), "no se pueden comparar con '" + ctx.op.getText()
                + "' valores de tipo " + l + " y " + r);
        return Type.ERROR;
    }

    @Override
    public Type visitAndExpr(SimpleParser.AndExprContext ctx) {
        return logical(visit(ctx.left), visit(ctx.right), "&&", ctx.getStart().getLine());
    }

    @Override
    public Type visitOrExpr(SimpleParser.OrExprContext ctx) {
        return logical(visit(ctx.left), visit(ctx.right), "||", ctx.getStart().getLine());
    }

    private Type logical(Type l, Type r, String op, int line) {
        if (l == Type.ERROR || r == Type.ERROR) return Type.ERROR;
        if (l == Type.BOOL && r == Type.BOOL) return Type.BOOL;
        error(line, "el operador '" + op + "' requiere operandos bool (recibió " + l + " y " + r + ")");
        return Type.ERROR;
    }

    @Override public Type visitIntLit(SimpleParser.IntLitContext ctx)       { return Type.INT; }
    @Override public Type visitRealLit(SimpleParser.RealLitContext ctx)     { return Type.REAL; }
    @Override public Type visitStringLit(SimpleParser.StringLitContext ctx) { return Type.STRING; }
    @Override public Type visitBoolLit(SimpleParser.BoolLitContext ctx)     { return Type.BOOL; }

    @Override
    public Type visitIdExpr(SimpleParser.IdExprContext ctx) {
        String name = ctx.ID().getText();
        Symbol s = symbols.resolve(name);
        if (s == null) {
            error(ctx.getStart().getLine(), "variable no declarada: '" + name + "'");
            return Type.ERROR;
        }
        return s.getType();
    }

    /* ===================== Helpers ===================== */

    private Type numericResult(Type l, Type r) {
        return (l == Type.REAL || r == Type.REAL) ? Type.REAL : Type.INT;
    }

    /** ¿Se puede asignar un valor de tipo {@code source} a un destino {@code target}? */
    private boolean assignable(Type target, Type source) {
        if (source == Type.ERROR) return true;            // ya reportado, no encadenar
        if (target == source) return true;
        if (target == Type.REAL && source == Type.INT) return true; // promoción int -> real
        return false;
    }

    /** Detecta un divisor literal cero (desenvuelve paréntesis). */
    private boolean isLiteralZero(SimpleParser.ExpressionContext ctx) {
        while (ctx instanceof SimpleParser.ParenExprContext) {
            ctx = ((SimpleParser.ParenExprContext) ctx).expression();
        }
        if (ctx instanceof SimpleParser.IntLitContext) {
            return Integer.parseInt(ctx.getText()) == 0;
        }
        if (ctx instanceof SimpleParser.RealLitContext) {
            return Double.parseDouble(ctx.getText()) == 0.0;
        }
        return false;
    }
}
