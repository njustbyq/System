package Stone.Token;

/**
 * String Token
 */

public class StrToken extends Token{

    private String text;

    public StrToken(int lineNo, String text) {
        super(lineNo);
        this.text = text;
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
