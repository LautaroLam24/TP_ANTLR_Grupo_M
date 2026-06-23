package com.miorganizacion.simple.interprete;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class Main {

    public static void main(String[] args) throws IOException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        String path = "src/test/resources/01_tipos_y_expresiones.smp";
        //String path = src/test/resources/02_if_else.smp
        //String path = src/test/resources/03_while.smp
        //String path = src/test/resources/04_errores_semanticos.smp
        //String path = src/test/resources/05_factorial.smp

        System.out.println("== Intérprete Simple == archivo: " + path);

        CharStream input = CharStreams.fromFileName(path);


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
