package Stone.Parser

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

        protected void parse (Lexer lexer, List<ASTree> res)
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

        
    }
     
 }