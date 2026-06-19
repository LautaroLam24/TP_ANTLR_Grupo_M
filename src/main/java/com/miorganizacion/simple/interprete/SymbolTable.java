package com.miorganizacion.simple.interprete;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Tabla de símbolos con manejo de ÁMBITOS (scopes) anidados.
 *
 * Se modela como una pila de mapas: cada bloque ({@code { ... }}) abre un
 * ámbito nuevo al entrar y lo cierra al salir. Esto permite:
 *  - detectar redeclaraciones dentro del MISMO ámbito;
 *  - resolver el uso de una variable buscándola desde el ámbito actual
 *    hacia afuera (los ámbitos externos siguen visibles).
 *
 * La misma clase se reutiliza en las dos pasadas (análisis y ejecución):
 * en el análisis interesa el tipo; en la ejecución, además, el valor.
 */
public class SymbolTable {

    private final Deque<Map<String, Symbol>> scopes = new ArrayDeque<>();

    public SymbolTable() {
        enterScope(); // ámbito global
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        scopes.pop();
    }

    /** ¿Ya existe una variable con ese nombre en el ámbito actual? (redeclaración) */
    public boolean existsInCurrentScope(String name) {
        return scopes.peek().containsKey(name);
    }

    /** Declara una variable en el ámbito actual. Devuelve el símbolo creado. */
    public Symbol declare(String name, Type type) {
        Symbol s = new Symbol(name, type);
        scopes.peek().put(name, s);
        return s;
    }

    /**
     * Busca una variable desde el ámbito actual hacia los externos.
     * Devuelve null si no está declarada en ningún ámbito visible.
     */
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
