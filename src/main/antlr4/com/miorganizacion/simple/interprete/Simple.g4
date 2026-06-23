grammar Simple;

/* =========================================================
   PARSER
   ========================================================= */

program
    : PROGRAM ID LBRACE statement* RBRACE EOF
    ;

statement
    : varDecl
    | assignment
    | printStmt
    | ifStmt
    | whileStmt
    ;

varDecl
    : VAR ID COLON type ( ASSIGN expression )? SEMI
    ;

// Asignación a una variable ya declarada
assignment
    : ID ASSIGN expression SEMI
    ;

// Instrucción de salida por consola
printStmt
    : PRINT LPAREN expression RPAREN SEMI
    ;

// Condicional if y else (el else es opcional)
ifStmt
    : IF LPAREN expression RPAREN block ( ELSE block )?
    ;

// VARIANTE 1: While
whileStmt
    : WHILE LPAREN expression RPAREN block
    ;

block
    : LBRACE statement* RBRACE
    ;

type
    : T_INT      # tipoInt
    | T_REAL     # tipoReal
    | T_STRING   # tipoString
    | T_BOOL     # tipoBool
    ;

// Expresiones con precedencia resuelta por el ORDEN de las alternativas
// (las de arriba ligan más fuerte). ANTLR4 maneja la recursión a izquierda.
expression
    : LPAREN expression RPAREN                                  # parenExpr
    | op=( MINUS | NOT ) expression                             # unaryExpr
    | left=expression op=( MULT | DIV ) right=expression        # mulDivExpr
    | left=expression op=( PLUS | MINUS ) right=expression      # addSubExpr
    | left=expression op=( GT | LT | GEQ | LEQ ) right=expression  # relExpr
    | left=expression op=( EQ | NEQ ) right=expression          # eqExpr
    | left=expression AND right=expression                      # andExpr
    | left=expression OR  right=expression                      # orExpr
    | INT_LIT                                                   # intLit
    | REAL_LIT                                                  # realLit
    | STRING_LIT                                                # stringLit
    | BOOL_LIT                                                  # boolLit
    | ID                                                        # idExpr
    ;

/* =========================================================
   LEXER
   ========================================================= */

// --- Palabras reservadas (deben ir ANTES de ID) ---
PROGRAM : 'program' ;
VAR     : 'var' ;
PRINT   : 'print' ;
IF      : 'if' ;
ELSE    : 'else' ;
WHILE   : 'while' ;

T_INT    : 'int' ;
T_REAL   : 'real' ;
T_STRING : 'string' ;
T_BOOL   : 'bool' ;

BOOL_LIT : 'true' | 'false' ;

// --- Operadores ---
PLUS  : '+' ;
MINUS : '-' ;
MULT  : '*' ;
DIV   : '/' ;

AND : '&&' ;
OR  : '||' ;
NOT : '!' ;

// Los de dos caracteres antes que los de uno (claridad; ANTLR usa maximal munch igual)
GEQ : '>=' ;
LEQ : '<=' ;
EQ  : '==' ;
NEQ : '!=' ;
GT  : '>' ;
LT  : '<' ;

ASSIGN : '=' ;

// --- Símbolos ---
LBRACE : '{' ;
RBRACE : '}' ;
LPAREN : '(' ;
RPAREN : ')' ;
SEMI   : ';' ;
COLON  : ':' ;

// --- Literales (REAL antes que INT para que gane el match más largo) ---
REAL_LIT   : [0-9]+ '.' [0-9]+ ;
INT_LIT    : [0-9]+ ;
STRING_LIT : '"' ( ~["\\\r\n] | '\\' . )* '"' ;
ID         : [a-zA-Z_] [a-zA-Z0-9_]* ;

// --- Comentarios y espacios (se descartan) ---
LINE_COMMENT  : '//' ~[\r\n]*    -> skip ;
BLOCK_COMMENT : '/*' .*? '*/'    -> skip ;
WS            : [ \t\r\n]+       -> skip ;
