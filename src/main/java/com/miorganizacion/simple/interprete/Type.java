package com.miorganizacion.simple.interprete;


public enum Type {
    INT,
    REAL,
    STRING,
    BOOL,
    // para no encadenar errores en cascada.
    ERROR;

    public boolean isNumeric() {
        return this == INT || this == REAL;
    }

    @Override
    public String toString() {
        switch (this) {
            case INT:    return "int";
            case REAL:   return "real";
            case STRING: return "string";
            case BOOL:   return "bool";
            default:     return "error";
        }
    }
}
