import compilerNode.*;
import type.*;
import visitor.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import Error.SemeticError;

import java.io.*;
import visitor.mlperParser.CompilationUnitContext;
public class Mainprocesser {
	static Map<String,definedtype> classtype;
	static Map<String,Function> topfuncs;
	static TopScope top;
    private static String readTestFile(String filePath) throws IOException {
        String ans = new String();
        File file = new File(filePath);
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        while ((tempString = reader.readLine()) != null) {
           ans += tempString + '\n';
        }
        reader.close();
        return ans;
    }
    public static void main(String[] args) throws SemeticError, IOException {
        /*InputStream is = new FileInputStream("F:\\eclipse-workspace\\compiler\\src\\example.txt"); // or System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);*/
    	CharStream input=CharStreams.fromString(readTestFile("program.txt"));
        mlperLexer lexer = new mlperLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mlperParser parser = new mlperParser(tokens);
        ParseTree tree = parser.compilationUnit(); 
        node ast;
        ast=new ASTconverter().visit(tree);
        classtype=new HashMap<String,definedtype>();
        topfuncs=new HashMap<String,Function>();
        setprimitivetype();
        Classnamecollecter col=new Classnamecollecter();
        col.Visit(ast);
        for (Map.Entry<String, Classdecnode> entry:col.classname.entrySet()) {
        	definedtype a=new definedtype(entry.getKey(),entry.getValue());
        	classtype.put(entry.getKey(), a);
        	entry.getValue().classtype=a;
        }
        for (Map.Entry<String, methoddec> entry:col.funcname.entrySet()) {
        	Function a=new Function(entry.getKey(),entry.getValue());
        	topfuncs.put(entry.getKey(), a);
        	entry.getValue().func=a;
        }
        Classmaker cmaker=new Classmaker(classtype,topfuncs);
        cmaker.Visit(ast);
        top=new TopScope();
        top.topfuncs=topfuncs;
        top.method=topfuncs;
        top.classtype=classtype;
        Scoperbuilder smaker=new Scoperbuilder(classtype,topfuncs,top);
        smaker.Visit(ast);
        
/*        System.out.println("Visitor:");
        EvalVisitor evalByVisitor = new EvalVisitor();
        evalByVisitor.visit(tree);
        System.out.println();*/
        
    }
    public static void setprimitivetype() {
    	 classtype.put("int",new definedtype("int",null));
         classtype.put("bool",new definedtype("bool",null));
         classtype.put("string",new definedtype("string",null));
         classtype.put("null", new definedtype("null",null));
         Function length;
         Function substring;
         Function ord;
         Function parseInt;
         definedtype inttype=classtype.get("int");
         ArrayorType ainttype=new ArrayorType("int",null,inttype,0);
         definedtype booltype=classtype.get("bool");
         definedtype stringtype=classtype.get("string");
         ArrayorType astringtype=new ArrayorType("string",null,stringtype,0);
         length=new Function("length",null);
         length.returnval=ainttype;
         stringtype.method.put("length",length);
         substring=new Function("substring",null);
         substring.returnval=astringtype;
         substring.attribute.add(new Variable("left",null,ainttype,null));
         substring.attribute.add(new Variable("right",null,ainttype,null));
         stringtype.method.put("substring", substring);
         ord=new Function("ord",null);
         ord.returnval=ainttype;
         ord.attribute.add(new Variable("pos",null,ainttype,null));
         stringtype.method.put("ord", ord);
         parseInt=new Function("parseInt",null);
         parseInt.returnval=ainttype;
         stringtype.method.put("parseInt",parseInt);
         Function print=new Function("print",null);
         print.ifvoid=true;
         print.attribute.add(new Variable("str",null,astringtype,null));
         topfuncs.put("print", print);
         Function println=new Function("println",null);
         println.ifvoid=true;
         println.attribute.add(new Variable("str",null,astringtype,null));
         topfuncs.put("println", println);
         Function getString=new Function("getString",null);
         getString.returnval=astringtype;
         topfuncs.put("getString", getString);
         Function getInt=new Function("getInt",null);
         getInt.returnval=ainttype;
         topfuncs.put("getInt", getInt);
         Function toString=new Function("toString",null);
         toString.returnval=astringtype;
         toString.attribute.add(new Variable("i",null,ainttype,null));
         topfuncs.put("toString", toString);
    }
}
