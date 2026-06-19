package com.miorganizacion.simple.interprete;

/**
 * Representa una variable dentro de la tabla de símbolos.
 *
 * En la pasada semántica interesa principalmente el {@code type} y si la
 * variable fue inicializada. En la pasada de ejecución, además, se guarda
 * el {@code value} en tiempo de ejecución (Integer, Double, String, Boolean).
 */
public class Symbol {

    private final String name;
    private final Type type;
    private Object value;
    private boolean initialized;

    public Symbol(String name, Type type) {
        this.name = name;
        this.type = type;
        this.value = null;
        this.initialized = false;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
        this.initialized = true;
    }

    public boolean isInitialized() {
        return initialized;
    }

    @Override
    public String toString() {
        return name + ":" + type;
    }
}
