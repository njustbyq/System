package Stone.Runner;

import Stone.Lexer;
import Stone.Exception.ParseException;
import Stone.Token.Token;
import Stone.UI.CodeDialog;

public class LexerRunner {

    public static void main(String[] args) throws ParseException {
        Lexer l = new Lexer(new CodeDialog());
        for (Token t; (t = l.read()) != Token.EOF; ) {
            System.out.println("=> " + t.getText());
        }
    }
}
