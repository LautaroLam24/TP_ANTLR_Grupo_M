package com.miorganizacion.simple.interprete;

/**
 * Error producido durante la EJECUCIÓN (no detectable estáticamente),
 * por ejemplo división por cero con divisor calculado, o el uso de una
 * variable declarada pero nunca inicializada.
 */
public class RuntimeError extends RuntimeException {
    public RuntimeError(int line, String message) {
        super("[línea " + line + "] " + message);
    }
}
