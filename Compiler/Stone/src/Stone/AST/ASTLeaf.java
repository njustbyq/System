package Stone.AST;
import Stone.Token;
import java.util.Iterator;

import Pava.AST.ASTree;
import Pava.Evaluator.BasicEvaluator.ASTLeafEx;

import java.util.ArrayList;

/**
 * Leaf node for abstract syntax tree
 */

public class ASTLeaf extends ASTree{
    private static ArrayList<ASTree> empty = new ArrayList<>();

    protected Token token;

    public ASTLeaf(Token token) {
        this.token = token;
    }

    @Override
    public ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int numChildren() {
        return 0;
    }
    
    @Override
    public Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    public String toString() {
        return this.token.getText();
    }

    @Override
    public String location() {
        return "at line " + this.token.getLineNumber(); 
    }

    public Token token() {
        return this.token;
    }

}
