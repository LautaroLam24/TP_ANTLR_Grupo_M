package com.miorganizacion.simple.interprete;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class SymbolTable {

    private final Deque<Map<String, Symbol>> scopes = new ArrayDeque<>();

    public SymbolTable() {
        enterScope();
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        scopes.pop();
    }

    public boolean existsInCurrentScope(String name) {
        return scopes.peek().containsKey(name);
    }

    public Symbol declare(String name, Type type) {
        Symbol s = new Symbol(name, type);
        scopes.peek().put(name, s);
        return s;
    }

    public Symbol resolve(String name) {
        for (Map<String, Symbol> scope : scopes) {
            Symbol s = scope.get(name);
            if (s != null) {
                return s;
            }
        }
        return null;
    }
}
