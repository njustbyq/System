package Stone.AST;

import Stone.Token.Token;
import java.util.List;

/**
 * Binary expression node for abstract tree
 */

public class BinaryExpr extends ASTList {
    public BinaryExpr(List<ASTree> children) {
        super(children); 
    }

    public ASTree left() {
        return child(0); 
    }

    public String operator() {
        return ((ASTree) child(1)).token().getText();
    }

    public ASTree right() {
        return child(2); 
    }
}