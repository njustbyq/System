package Stone.Parser;

import Stone.AST.ASTLeaf;
import Stone.AST.ASTList;
import Stone.AST.ASTree;
import Stone.Exception.ParseException;
import Stone.Lexer;
import Stone.Token.Token;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.invoke.ClassSpecializer.Factory;
import java.lang.reflect.Constructor;

/**
 * A parser for grammatical analysis
 */

public class Parser {
    protected static abstract class Element {
        protected abstract void parse(Lexer lexer, List<ASTree> res)
                throws ParseException;
         
        protected abstract boolean match(Lexer lexer) throws ParseException;
    }

    protected static class Tree extends Element {
        protected Parser parser;

        protected Tree(Parser p) {
            parser = p;
        }

        protected void parse(Lexer lexer, List<ASTree> res)
                throws ParseException {
            res.add(parser.parse(lexer));
        }

        protected boolean match(Lexer lexer) throws ParseException {
            return parser.match(lexer);
        }
    }

    protected static class OrTree extends Element {
        protected Parser[] parsers;

        protected OrTree(Parser[] p) {
            parsers = p;
        }

        protected void parse(Lexer lexer, List<ASTree> res) 
                throws ParseException {
            Parser p = choose(lexer);
            if (p == null) 
                throw new ParseException(lexer.peek(0));
            else    
                res.add(p.parse(lexer));
        }

        protected boolean match(Lexer lexer) throws ParseException {
            return choose(lexer) != null;
        }

        protected Parser choose(Lexer lexer) throws ParseException {
            for (Parser p : parsers)
                if (p.match(lexer))
                    return p;
            
            return null;
        }

        protected void insert(Parser p) {
            Parser[] newParsers = new Parser[parsers.length + 1];
            newParsers[0] = p;
            System.arraycopy(parsers, 0, newParsers, 1, parsers.length);
            parsers = newParsers;
        }
    }

    protected static class Repeat extends Element {
        protected Parser parser;
        protected boolean onlyOnce;

        protected Repeat(Parser p, boolean once) {
            parser = p;
            onlyOnce = once;
        }

        protected void parse(Lexer lexer, List<Pava.AST.ASTree> res)
                throws ParseException {
            while (parser.match(lexer)) {
                Pava.AST.ASTree t = parser.parse(lexer);
                if (t.getClass() != ASTList.class || t.numChildren() > 0)
                    res.add(t);
                if (onlyOnce)
                    break;
            }
        }

        protected boolean match(Lexer lexer) throws ParseException {
            return parser.match(lexer);
        }
    }

    protected static abstract class AToken extends Element {
        protected Factory factory;

        protected AToken(Class<? extends ASTLeaf> type) {
            if (type == null)
                type = ASTLeaf.class;
            factory = Factory.get(type, Token.class);
        }

        protected void parse(Lexer lexer, List<ASTLeaf> res)
                throws ParseException {
            Token t = lexer.read();
            if (test(t)) {
                ASTLeaf leaf = factory.make(t);
                res.add(leaf);
            } else
                throw new ParseException(t);
        }

        protected boolean match(Lexer lexer) throws ParseException {
            return test(lexer.peek(0));
        }

        protected abstract boolean test(Token t);
    }

    protected static class IdToken extends AToken {
        HashSet<String> reserved;

        protected IdToken(Class<? extends ASTLeaf> type, HashSet<String> r) {
            super(type);
            reserved = r != null ? r : new HashSet<String>();
        }

        protected boolean test(Pava.Token.Token t) {
            return t.isIdentifier() && !reserved.contains(t.getText());
        }
    }

    protected static class NumToken extends AToken {
        protected NumToken(Class<? extends ASTLeaf> type) {
            super(type);
        }

        protected boolean test(Pava.Token.Token t) {
            return t.isNumber();
        }     
    }
    
    

}    