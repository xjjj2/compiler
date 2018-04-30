import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import compilerNode.*;
import visitor.*;
import visitor.mlperParser.CompilationUnitContext;
import type.*;
public class test {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("F:\\eclipse-workspace\\compiler\\src\\example.txt"); // or System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);
        mlperLexer lexer = new mlperLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mlperParser parser = new mlperParser(tokens);
        ParseTree tree = parser.compilationUnit(); 
        node ast;
        ast=new ASTconverter().visit(tree);
        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));
        System.out.println();
/*        System.out.println("Visitor:");
        EvalVisitor evalByVisitor = new EvalVisitor();
        evalByVisitor.visit(tree);
        System.out.println();*/

    }
}
