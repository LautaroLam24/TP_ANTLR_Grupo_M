package com.miorganizacion.simple.interprete;


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
