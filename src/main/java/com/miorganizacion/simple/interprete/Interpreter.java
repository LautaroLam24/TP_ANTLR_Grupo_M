package com.miorganizacion.simple.interprete;

/**
 * SEGUNDA PASADA: ejecución.
 *
 * Solo corre si el análisis semántico no encontró errores. Recorre el árbol
 * con el patrón Visitor evaluando expresiones (devuelve Integer, Double,
 * String o Boolean) y ejecutando las sentencias (asignaciones, print,
 * if-else y while).
 *
 * Mantiene su propia {@link SymbolTable} con los VALORES en tiempo de
 * ejecución, con el mismo manejo de ámbitos que el analizador.
 */
public class Interpreter extends SimpleBaseVisitor<Object> {

    private final SymbolTable env = new SymbolTable();

    /* ===================== Programa y sentencias ===================== */

    @Override
    public Object visitProgram(SimpleParser.ProgramContext ctx) {
        for (SimpleParser.StatementContext st : ctx.statement()) {
            visit(st);
        }
        return null;
    }

    @Override
    public Object visitVarDecl(SimpleParser.VarDeclContext ctx) {
        String name = ctx.ID().getText();
        Type declared = typeOf(ctx.type());
        Symbol s = env.declare(name, declared);
        if (ctx.expression() != null) {
            Object value = coerce(declared, visit(ctx.expression()));
            s.setValue(value);
        }
        return null;
    }

    @Override
    public Object visitAssignment(SimpleParser.AssignmentContext ctx) {
        String name = ctx.ID().getText();
        Symbol s = env.resolve(name);
        Object value = coerce(s.getType(), visit(ctx.expression()));
        s.setValue(value);
        return null;
    }

    @Override
    public Object visitPrintStmt(SimpleParser.PrintStmtContext ctx) {
        Object value = visit(ctx.expression());
        System.out.println(format(value));
        return null;
    }

    @Override
    public Object visitIfStmt(SimpleParser.IfStmtContext ctx) {
        boolean cond = (Boolean) visit(ctx.expression());
        if (cond) {
            visit(ctx.block(0));
        } else if (ctx.block().size() > 1) {
            visit(ctx.block(1));
        }
        return null;
    }

    @Override
    public Object visitWhileStmt(SimpleParser.WhileStmtContext ctx) {
        while ((Boolean) visit(ctx.expression())) {
            visit(ctx.block());
        }
        return null;
    }

    @Override
    public Object visitBlock(SimpleParser.BlockContext ctx) {
        env.enterScope();
        for (SimpleParser.StatementContext st : ctx.statement()) {
            visit(st);
        }
        env.exitScope();
        return null;
    }

    /* ===================== Expresiones ===================== */

    @Override
    public Object visitParenExpr(SimpleParser.ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitUnaryExpr(SimpleParser.UnaryExprContext ctx) {
        Object v = visit(ctx.expression());
        if (ctx.op.getText().equals("-")) {
            if (v instanceof Integer) return -(Integer) v;
            return -(Double) v;
        }
        return !(Boolean) v; // '!'
    }

    @Override
    public Object visitMulDivExpr(SimpleParser.MulDivExprContext ctx) {
        Object l = visit(ctx.left);
        Object r = visit(ctx.right);
        int line = ctx.getStart().getLine();
        boolean div = ctx.op.getText().equals("/");

        if (l instanceof Integer && r instanceof Integer) {
            int a = (Integer) l, b = (Integer) r;
            if (div) {
                if (b == 0) throw new RuntimeError(line, "división por cero");
                return a / b;
            }
            return a * b;
        }
        double a = toDouble(l), b = toDouble(r);
        if (div) {
            if (b == 0.0) throw new RuntimeError(line, "división por cero");
            return a / b;
        }
        return a * b;
    }

    @Override
    public Object visitAddSubExpr(SimpleParser.AddSubExprContext ctx) {
        Object l = visit(ctx.left);
        Object r = visit(ctx.right);
        boolean plus = ctx.op.getText().equals("+");

        if (plus && l instanceof String && r instanceof String) {
            return (String) l + (String) r;
        }
        if (l instanceof Integer && r instanceof Integer) {
            int a = (Integer) l, b = (Integer) r;
            return plus ? a + b : a - b;
        }
        double a = toDouble(l), b = toDouble(r);
        return plus ? a + b : a - b;
    }

    @Override
    public Object visitRelExpr(SimpleParser.RelExprContext ctx) {
        double a = toDouble(visit(ctx.left));
        double b = toDouble(visit(ctx.right));
        switch (ctx.op.getText()) {
            case ">":  return a > b;
            case "<":  return a < b;
            case ">=": return a >= b;
            default:   return a <= b; // "<="
        }
    }

    @Override
    public Object visitEqExpr(SimpleParser.EqExprContext ctx) {
        Object l = visit(ctx.left);
        Object r = visit(ctx.right);
        boolean equal;
        if (l instanceof Number && r instanceof Number) {
            equal = toDouble(l) == toDouble(r);
        } else {
            equal = l.equals(r);
        }
        return ctx.op.getText().equals("==") ? equal : !equal;
    }

    @Override
    public Object visitAndExpr(SimpleParser.AndExprContext ctx) {
        // cortocircuito: si el izquierdo es false, no evalúa el derecho
        if (!(Boolean) visit(ctx.left)) return false;
        return (Boolean) visit(ctx.right);
    }

    @Override
    public Object visitOrExpr(SimpleParser.OrExprContext ctx) {
        if ((Boolean) visit(ctx.left)) return true;
        return (Boolean) visit(ctx.right);
    }

    @Override
    public Object visitIntLit(SimpleParser.IntLitContext ctx) {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public Object visitRealLit(SimpleParser.RealLitContext ctx) {
        return Double.parseDouble(ctx.getText());
    }

    @Override
    public Object visitStringLit(SimpleParser.StringLitContext ctx) {
        return unescape(ctx.getText());
    }

    @Override
    public Object visitBoolLit(SimpleParser.BoolLitContext ctx) {
        return Boolean.parseBoolean(ctx.getText());
    }

    @Override
    public Object visitIdExpr(SimpleParser.IdExprContext ctx) {
        Symbol s = env.resolve(ctx.ID().getText());
        if (!s.isInitialized()) {
            throw new RuntimeError(ctx.getStart().getLine(),
                    "variable '" + s.getName() + "' usada sin inicializar");
        }
        return s.getValue();
    }

    /* ===================== Helpers ===================== */

    private Type typeOf(SimpleParser.TypeContext ctx) {
        switch (ctx.getText()) {
            case "int":    return Type.INT;
            case "real":   return Type.REAL;
            case "string": return Type.STRING;
            default:       return Type.BOOL;
        }
    }

    /** Promueve un Integer a Double cuando la variable destino es real. */
    private Object coerce(Type target, Object value) {
        if (target == Type.REAL && value instanceof Integer) {
            return ((Integer) value).doubleValue();
        }
        return value;
    }

    private double toDouble(Object o) {
        return ((Number) o).doubleValue();
    }

    /** Formatea un valor para imprimirlo por consola. */
    private String format(Object value) {
        if (value instanceof Double) {
            double d = (Double) value;
            if (d == Math.floor(d) && !Double.isInfinite(d)) {
                return String.valueOf((long) d) + ".0";
            }
        }
        return String.valueOf(value);
    }

    /** Quita las comillas externas e interpreta los escapes básicos. */
    private String unescape(String raw) {
        String body = raw.substring(1, raw.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < body.length(); i++) {
            char c = body.charAt(i);
            if (c == '\\' && i + 1 < body.length()) {
                char next = body.charAt(++i);
                switch (next) {
                    case 'n': sb.append('\n'); break;
                    case 't': sb.append('\t'); break;
                    case '"': sb.append('"');  break;
                    case '\\': sb.append('\\'); break;
                    default:  sb.append(next);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
