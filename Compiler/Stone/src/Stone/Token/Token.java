package Stone.Token;

/**
 * Token Class
 * Created by yqbao on 2021/12/25
 */

public class Token {
    // end of file
    public static final Token EOF = new Token(-1) {};
    // end of line
    public static final String EOL = "\\n";
    // the line number of this token 
    private int lineNumber;

    protected Token(int line) {
        lineNumber = line;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    /* type of token */
    public boolean isIdentifier() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    /* get value from token */
    public int getNumber() {
        return -1;
    }

    public String getText() {
        return "";
    }
}
