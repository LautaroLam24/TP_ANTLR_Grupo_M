package com.miorganizacion.simple.interprete;

/**
 * Tipos de datos soportados por el lenguaje.
 * Se usa tanto en el análisis semántico (para chequear compatibilidad)
 * como para razonar sobre promociones numéricas (int -> real).
 */
public enum Type {
    INT,
    REAL,
    STRING,
    BOOL,
    // Tipo de error: se devuelve cuando una sub-expresión ya falló,
    // para no encadenar errores en cascada.
    ERROR;

    public boolean isNumeric() {
        return this == INT || this == REAL;
    }

    /** Nombre tal como se escribe en el lenguaje fuente. */
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
