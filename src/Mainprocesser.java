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
	static List<Variable> topvars;
	static TopScope top;
	static List<String> nasm;
	public static String Loadlib() {
		 String s="extern scanf\n" + "extern printf\n" + "extern puts\n" + "extern strlen\n" + "extern memcpy\n" + "extern sscanf\n" + "extern sprintf\n" + "extern malloc\n" + "extern strcmp\n" + "\n";
	        String s2 = "\n" + //get it from others . Thanks!
	                "\n" +
	                "section .data\n" +
	                "intbuffer:\n" +
	                "    dq 0\n" +
	                "format1:\n" +
	                "    db\"%lld\",0\n" +
	                "format2:\n" +
	                "    db\"%lld \",10,0\n" +
	                "format3:\n" +
	                "    db\"%s\",0\n" +
	                "format4:\n" +
	                "    db\"%s\",10,0\n" +
	                "\n" +
	                "section .bss\n" +
	                "stringbuffer:\n" +
	                "    resb 256\n" +
	                "\n" +
	                "section .text\n" +
	                "getInt:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    mov rax,0\n" +
	                "    mov rdi,format1\n" +
	                "    mov rsi,intbuffer\n" +
	                "    call scanf\n" +
	                "    mov rax,[intbuffer]\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "printInt:\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    mov rsi,rdi\n" +
	                "    mov rax,0\n" +
	                "    mov rdi,format2\n" +
	                "    call printf\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                /*"size:\n" +
	                "    mov rax,[rdi-8]\n" +
	                "    ret\n" +
	                "\n" +*/
	                "print:\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    mov rax,0\n" +
	                "    mov rsi,rdi\n" +
	                "    mov rdi,format3\n" +
	                "    call printf\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "println:\n" +
	                "\n" +
	                "    call puts\n" +
	                "    ret\n" +
	                "\n" +
	                "\n" +
	                "transtring:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strlen\n" +
	                "    push rdi\n" +
	                "    mov rdi,rax\n" +
	                "    push rdi\n" +
	                "    add rdi,9\n" +
	                "    call malloc\n" +
	                "    pop rdi\n" +
	                "    mov [rax],rdi\n" +
	                "    add rax,8\n" +
	                "    mov rdx,rdi\n" +
	                "    add rdx,1\n" +
	                "    mov rdi,rax\n" +
	                "    pop rsi\n" +
	                "    sub rsp,8\n" +
	                "    push rax\n" +
	                "    call memcpy\n" +
	                "    pop rax\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "getString:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    mov rax,0\n" +
	                "    mov rdi,format3\n" +
	                "    mov rsi,stringbuffer\n" +
	                "    call scanf\n" +
	                "    mov rdi,stringbuffer\n" +
	                "    call transtring\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "\n" +
	                "ALIGN   16\n" +
	                "\n" +
	                "toString:\n" +
	                "        push    rbx\n" +
	                "        mov     rbx, rdi\n" +
	                "        mov     edi, 20\n" +
	                "        call    malloc\n" +
	                "        test    rbx, rbx\n" +
	                "        mov     r9, rax\n" +
	                "        lea     rdi, [rax+8H]\n" +
	                "        js      L_007\n" +
	                "        jne     L_010\n" +
	                "        lea     rcx, [rax+9H]\n" +
	                "        mov     byte [rax+8H], 48\n" +
	                "        mov     rsi, rcx\n" +
	                "L_004:  mov     rax, rcx\n" +
	                "        mov     byte [rcx], 0\n" +
	                "        sub     rax, rdi\n" +
	                "        mov     qword [r9], rax\n" +
	                "        lea     rax, [rcx-1H]\n" +
	                "        cmp     rax, rsi\n" +
	                "        jc      L_006\n" +
	                "L_005:  movzx   edx, byte [rsi]\n" +
	                "        movzx   ecx, byte [rax]\n" +
	                "        add     rsi, 1\n" +
	                "        sub     rax, 1\n" +
	                "        mov     byte [rsi-1H], cl\n" +
	                "        mov     byte [rax+1H], dl\n" +
	                "        cmp     rsi, rax\n" +
	                "        jbe     L_005\n" +
	                "L_006:  mov     rax, rdi\n" +
	                "        pop     rbx\n" +
	                "        ret\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "ALIGN   8\n" +
	                "L_007:  lea     rsi, [rax+9H]\n" +
	                "        mov     byte [rax+8H], 45\n" +
	                "        neg     rbx\n" +
	                "L_008:  mov     rcx, rsi\n" +
	                "        mov     r8, qword 6666666666666667H\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "ALIGN   16\n" +
	                "L_009:  mov     rax, rbx\n" +
	                "        add     rcx, 1\n" +
	                "        imul    r8\n" +
	                "        mov     rax, rbx\n" +
	                "        add     ebx, 48\n" +
	                "        sar     rax, 63\n" +
	                "        sar     rdx, 2\n" +
	                "        sub     rdx, rax\n" +
	                "        lea     eax, [rdx+rdx*4]\n" +
	                "        add     eax, eax\n" +
	                "        sub     ebx, eax\n" +
	                "        test    rdx, rdx\n" +
	                "        mov     byte [rcx-1H], bl\n" +
	                "        mov     rbx, rdx\n" +
	                "        jnz     L_009\n" +
	                "        jmp     L_004\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "ALIGN   8\n" +
	                "L_010:  mov     rsi, rdi\n" +
	                "        jmp     L_008\n" +
	                "\n" +
	                "\n" +
	                "\n" +
	                "_length_string:\n" +
	                "\n" +
	                "    mov rax,[rdi-8]\n" +
	                "    ret\n" +
	                "\n" +
	                "\n" +
	                "ALIGN   8\n" +
	                "\n" +
	                "_substring_string:\n" +
	                "        push    r13\n" +
	                "        sub     rdx, rsi\n" +
	                "        push    r12\n" +
	                "        push    rbp\n" +
	                "        push    rbx\n" +
	                "        mov     r12, rdi\n" +
	                "        lea     rbx, [rdx+1H]\n" +
	                "        lea     rdi, [rdx+0AH]\n" +
	                "        mov     rbp, rsi\n" +
	                "        sub     rsp, 8\n" +
	                "        call    malloc\n" +
	                "        test    rbx, rbx\n" +
	                "        mov     r13, rax\n" +
	                "        mov     qword [rax], rbx\n" +
	                "        lea     rcx, [rax+8H]\n" +
	                "        jle     L_003\n" +
	                "        lea     rsi, [r12+rbp]\n" +
	                "        mov     rdi, rcx\n" +
	                "        mov     rdx, rbx\n" +
	                "        call    memcpy\n" +
	                "        mov     rcx, rax\n" +
	                "L_003:  mov     byte [r13+rbx+8H], 0\n" +
	                "        add     rsp, 8\n" +
	                "        mov     rax, rcx\n" +
	                "        pop     rbx\n" +
	                "        pop     rbp\n" +
	                "        pop     r12\n" +
	                "        pop     r13\n" +
	                "        ret\n" +
	                "\n" +
	                "\n" +
	                "        nop\n" +
	                "\n" +
	                "\n" +
	                "_parseInt_string:\n" +
	                "\n" +
	                "    mov rsi,format1\n" +
	                "    mov rdx,intbuffer\n" +
	                "    mov rax,0\n" +
	                "    call sscanf\n" +
	                "    mov rax,[intbuffer]\n" +
	                "    ret\n" +
	                "\n" +
	                "_ord_string:\n" +
	                "\n" +
	                "    mov rax,0\n" +
	                "    mov al,byte[rdi+rsi]\n" +
	                "    ret\n" +
	                "    \n" +
	                "_Str_ADD:\n" +
	                "        push    r15\n" +
	                "        push    r14\n" +
	                "        mov     r15, rdi\n" +
	                "        push    r13\n" +
	                "        push    r12\n" +
	                "        mov     r14, rsi\n" +
	                "        push    rbp\n" +
	                "        push    rbx\n" +
	                "        sub     rsp, 8\n" +
	                "        mov     rbp, qword [rdi-8H]\n" +
	                "        mov     r12, qword [rsi-8H]\n" +
	                "        lea     rbx, [rbp+r12]\n" +
	                "        lea     rdi, [rbx+9H]\n" +
	                "        call    malloc\n" +
	                "        test    rbp, rbp\n" +
	                "        mov     qword [rax], rbx\n" +
	                "        mov     r13, rax\n" +
	                "        lea     rbx, [rax+8H]\n" +
	                "        jle     L_001\n" +
	                "        mov     rdx, rbp\n" +
	                "        mov     rsi, r15\n" +
	                "        mov     rdi, rbx\n" +
	                "        call    memcpy\n" +
	                "L_001:  add     rbx, rbp\n" +
	                "        test    r12, r12\n" +
	                "        jle     L_002\n" +
	                "        lea     rdi, [r13+rbp+8H]\n" +
	                "        mov     rdx, r12\n" +
	                "        mov     rsi, r14\n" +
	                "        call    memcpy\n" +
	                "L_002:  mov     byte [rbx+r12], 0\n" +
	                "        mov     rax, rbx\n" +
	                "        add     rsp, 8\n" +
	                "        pop     rbx\n" +
	                "        sub     rax, rbp\n" +
	                "        pop     rbp\n" +
	                "        pop     r12\n" +
	                "        pop     r13\n" +
	                "        pop     r14\n" +
	                "        pop     r15\n" +
	                "        ret\n" +
	                "\n" +
	                "\n" +
	                "_Str_LT:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strcmp\n" +
	                "    mov rdi,0\n" +
	                "    cmp rax,0\n" +
	                "    setl dil\n" +
	                "    mov rax,rdi\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "_Str_LE:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strcmp\n" +
	                "    mov rdi,0\n" +
	                "    cmp rax,0\n" +
	                "    setle dil\n" +
	                "    mov rax,rdi\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "_Str_GT:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strcmp\n" +
	                "    mov rdi,0\n" +
	                "    cmp rax,0\n" +
	                "    setg dil\n" +
	                "    mov rax,rdi\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "_Str_GE:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strcmp\n" +
	                "    mov rdi,0\n" +
	                "    cmp rax,0\n" +
	                "    setge dil\n" +
	                "    mov rax,rdi\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "_Str_EQ:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strcmp\n" +
	                "    mov rdi,0\n" +
	                "    cmp rax,0\n" +
	                "    sete dil\n" +
	                "    mov rax,rdi\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n" +
	                "\n" +
	                "_Str_NE:\n" +
	                "\n" +
	                "    push rbp\n" +
	                "    mov rbp,rsp\n" +
	                "    call strcmp\n" +
	                "    mov rdi,0\n" +
	                "    cmp rax,0\n" +
	                "    setne dil\n" +
	                "    mov rax,rdi\n" +
	                "    mov rsp,rbp\n" +
	                "    pop rbp\n" +
	                "    ret\n";
	        return s+s2;
	}
	public static class VerboseListener extends BaseErrorListener {
		@Override
		public void syntaxError(Recognizer<?, ?> recognizer,
		Object offendingSymbol,
		int line, int charPositionInLine,
		String msg,
		RecognitionException e)
		{
		List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
		Collections.reverse(stack);
		System.err.println("rule stack: "+stack);
		System.err.println("line "+line+":"+charPositionInLine+" at "+
		offendingSymbol+": "+msg);
		}
		}
	public static class BailmlperLexer extends mlperLexer {
		public BailmlperLexer(CharStream input) { super(input); }
		public void recover(LexerNoViableAltException e) {
		throw new RuntimeException(e); // Bail out
		}
		}
/*	private static String readTestFile(String filePath) throws IOException {
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
    }*/
    public static void main(String[] args) throws SemeticError, IOException {
    	boolean test=false;
    	String name;
    	if (test) name="F:\\eclipse-workspace\\compiler\\src\\example.txt";
    	else name="program.txt";
        InputStream is = new FileInputStream(name); // or System.in;
        ANTLRInputStream input = new ANTLRInputStream(is);
        BailmlperLexer lexer = new BailmlperLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mlperParser parser = new mlperParser(tokens);
        parser.setErrorHandler(new BailErrorStrategy());
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
        if (!topfuncs.containsKey("main")) throw new SemeticError("no main");
        else {
        	ArrayorType maintype=topfuncs.get("main").returnval;
        	if(!maintype.name.equals("int") || maintype.arraynum>0) throw new SemeticError("not int main");
        }
        top=new TopScope();
        top.topfuncs=topfuncs;
        top.method=topfuncs;
        top.classtype=classtype;
        Scoperbuilder smaker=new Scoperbuilder(classtype,topfuncs,top);
        smaker.Visit(ast);
        topvars=top.seq;
        LinearIRconverter ir=new LinearIRconverter(topfuncs,topvars,classtype);
        ir.Visit(ast);
        Liveliness lv=new Liveliness(ir.quadlist,ir.tempset,ir.tempset2,ir.lab2fun);
         lv.liveliness();
        Nasmmaker maker=new Nasmmaker(ir.quadlist,ir.global,ir.contoplist,ir.restoplist,ir.lab2fun);
        maker.make();
        System.out.print(Loadlib());
        while (maker.nasmlist.size()>0) {
        	System.out.println(maker.nasmlist.pollFirst());
        }
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
         inttype.typelong=4;
         ArrayorType ainttype=new ArrayorType("int",null,inttype,0);
         definedtype booltype=classtype.get("bool");
         booltype.typelong=1;
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
