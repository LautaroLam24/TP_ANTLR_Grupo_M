package com.miorganizacion.simple.interprete;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Punto de entrada del intérprete.
 *
 * Flujo:
 *   1. Análisis léxico y sintáctico con ANTLR (errores acumulados).
 *   2. Si hubo errores léxicos/sintácticos -> se reportan y se aborta.
 *   3. Análisis semántico (SemanticAnalyzer).
 *   4. Si hubo errores semánticos -> se reportan y se aborta.
 *   5. Ejecución (Interpreter).
 *
 * Uso:
 *   mvn exec:java -Dexec.args="ruta/al/programa.smp"
 *   (sin argumentos toma src/test/resources/test.smp por defecto)
 */
public class Main {

    private static final String DEFAULT_FILE = "src/test/resources/test.smp";

    public static void main(String[] args) throws IOException {
        // Salida en UTF-8 para que los acentos se vean bien en cualquier consola
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        String path = "src/test/resources/04_errores_semanticos.smp";
        //String path = (args.length == 0) ? DEFAULT_FILE : args[0];
        System.out.println("== Intérprete Simple == archivo: " + path);

        CharStream input = CharStreams.fromFileName(path);

        // --- Léxico + sintáctico, con listener que acumula errores ---
        SyntaxErrorListener syntaxErrors = new SyntaxErrorListener();

        SimpleLexer lexer = new SimpleLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(syntaxErrors);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        SimpleParser parser = new SimpleParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrors);

        SimpleParser.ProgramContext tree = parser.program();

        if (syntaxErrors.hasErrors()) {
            report("Errores léxicos/sintácticos", syntaxErrors.getErrors());
            return;
        }

        // --- Semántico ---
        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        analyzer.visit(tree);
        if (analyzer.hasErrors()) {
            report("Errores semánticos", analyzer.getErrors());
            return;
        }

        // --- Ejecución ---
        System.out.println("--- salida del programa ---");
        try {
            new Interpreter().visit(tree);
        } catch (RuntimeError e) {
            System.out.println();
            System.out.println("Error en tiempo de ejecución: " + e.getMessage());
            return;
        }
        System.out.println("--- fin ---");
    }

    private static void report(String header, java.util.List<String> errors) {
        System.out.println();
        System.out.println(header + " (" + errors.size() + "):");
        for (String e : errors) {
            System.out.println("  - " + e);
        }
    }
}
