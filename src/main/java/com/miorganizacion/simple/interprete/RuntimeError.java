package com.miorganizacion.simple.interprete;

public class RuntimeError extends RuntimeException {
    public RuntimeError(int line, String message) {
        super("[línea " + line + "] " + message);
    }
}
