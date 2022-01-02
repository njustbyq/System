package Stone.Exception;

import Stone.Token.Token;

import java.io.IOException;

/**
 * Parse Exception for Lexer
 */

public class ParseException extends Exception{
    public ParseException(Token t) {
        this("", t);
    }

    public ParseException(String msg, Token t) {
        super("Syntax error around " + location(t) + ". " + msg);
    }
    private static String location(Token t) {
        if (t == Token.EOF)
            return "the last line";
        else 
            return "\"" + t.getText() + "\" at line " + t.getLineNumber();
    }

    public ParseException(IOException e) {
        super(e);
    }

    public ParseException(String msg) {
        super(msg);
    }

}
