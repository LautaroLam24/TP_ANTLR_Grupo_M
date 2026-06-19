package com.miorganizacion.simple.interprete;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Reemplaza el listener por defecto de ANTLR (que solo imprime en stderr y
 * sigue) por uno que ACUMULA los errores léxicos y sintácticos para que
 * {@code Main} pueda reportarlos juntos y abortar antes de ejecutar.
 *
 * Se conecta tanto al lexer como al parser.
 */
public class SyntaxErrorListener extends BaseErrorListener {

    private final List<String> errors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        errors.add("[línea " + line + ":" + charPositionInLine + "] " + msg);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
