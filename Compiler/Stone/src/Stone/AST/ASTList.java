import Pava.AST.ASTree;

import java.util.List;
import java.util.Iterator;

/**
 * A list node for abstract syntax tree
 */

public class ASTList extends ASTree{
    protected List<ASTree> children;

    public ASTList (List<ASTree> children) { 
        this.children = children; 
    }
    
    @Override
    public ASTree child(int i) { 
        return children.get(i); 
    }
    
    @Override
    public int numChildren() {
        return children.size(); 
    }

    @Override
    public Iterator<ASTree> children() { 
        return children.iterator(); 
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        String sep = "";
        for (ASTree t: children) {
            builder.append(sep);
            sep = " ";
            builder.append('(').toString();
        }
        return builder.append(')').toString();
    }

    @Override
    public Stirng location() {
        for (ASTree t: children) {
            String s = t.location();
            if(s != null) 
                return s;
        }
        return null;
    }
}
