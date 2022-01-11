package Stone.AST;

import Stone.Token.Token;

/**
 * Number literal node for abstract syntax tree
 */

public class NumberLiteral extends ASTLeaf {

    public NumberLiteral(Token token) {
        super(token); 
    }

    public int value() {
        return token().getNumber(); 
    }
}