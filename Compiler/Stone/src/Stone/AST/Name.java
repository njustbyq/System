package Stone.AST;

import Stone.Token.Token;

/**
 * Word literal for abstract syntax tree
 */

public class Name extends ASTList {
    public Name(Token token) {
        super(token); 
    }

    public Stirng name() {
        return token().getText(); 
    }
}