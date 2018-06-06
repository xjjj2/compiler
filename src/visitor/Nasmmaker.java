package visitor;
import java.util.*;
import Error.SemeticError;
import IR.*;
import type.*;
public class Nasmmaker {
	public List<Quad> quadlist;
	public List<String> global;
	public List<Conststring> contoplist;
	public List<Resarea> restoplist;
	public LinkedList<String> nasmlist;
	public Map<Label,Function> lab2fun;
	public boolean[] usage;
	final public String[] regname= {"rax","rbx","rcx","rdx","rsi","rdi","rbp","rsp","r8","r9","r10","r11","r12","r13","r14","r15"};
	final public String[] attrname= {"rdi","rsi","rdx","rcx","r8","r9"};
	public Var[] regvar;
	public LinkedList<Integer> usageque;
	public Map<String,Integer> regint;
	public void init() {
		usage=new boolean[16];
		regvar=new Var[16];
		usage[0]=true;
		usage[2]=true;
		usage[3]=true;
		usage[6]=true;
		usage[7]=true;
		usageque=new LinkedList<Integer>();
	}
	public Nasmmaker(List<Quad> quadlist,List<String> global,List<Conststring> conlist,List<Resarea> reslist,Map<Label,Function> lab2fun) {
		init();
		this.quadlist=quadlist;
		this.global=global;
		this.contoplist=conlist;
		this.restoplist=reslist;
		this.lab2fun=lab2fun;
		nasmlist=new LinkedList<>();
		regint=new HashMap<>();
		for (int i=0;i<16;++i) {
			regint.put(regname[i], i);
		}
	}
	public boolean isAssign(Quad i) {
		return (i.getClass().equals(AssignQuad.class));
	}
	public boolean isBinary(Quad i) {
		return (i.getClass().equals(BinaryQuad.class));
	}
	public boolean isCall(Quad i) {
		return (i.getClass().equals(Call.class));
	}
	public boolean isCJump(Quad i) {
		return (i.getClass().equals(CJumpQuad.class));
	}
	public boolean isJump(Quad i) {
		return (i.getClass().equals(JumpQuad.class));
	}
	public boolean isLabel(Quad i) {
		return (i.getClass().equals(Label.class));
	}
	public boolean isMalloc(Quad i) {
		return (i.getClass().equals(MallocQuad.class));
	}
	public boolean isParam(Quad i) {
		return (i.getClass().equals(Param.class));
	}
	public boolean isReturn(Quad i) {
		return (i.getClass().equals(Return.class));
	}
	public boolean isUniary(Quad i) {
		return (i.getClass().equals(UniQuad.class));
	}
	public boolean isConststring(Var i) {
		return (i.getClass().equals(Conststring.class));
	}
	public boolean isImm(Var i) {
		return (i.getClass().equals(Imm.class));
	}
	public boolean isMem(Var i) {
		return (i.getClass().equals(Mem.class));
	}
	public boolean isResarea(Var i) {
		return (i.getClass().equals(Resarea.class));
	}
	public boolean isTemp(Var i) {
		return (i.getClass().equals(Temp.class));
	}
	public void Binary(String op,String a,String b) {
		nasmlist.add(op+"\t"+a+" , "+b);
	}
	public void Unary(String op,String a) {
		nasmlist.add(op+"\t"+a);
	}
	public String getname(Var i) throws SemeticError {
		if (isImm(i)) {
			return getimm((Imm)i);
		}
		if (isMem(i)) {
			return getmem((Mem)i);
		}
		if (((Vari)i).colornum==-1) 
			return getmem((Vari)i);
		return regname[((Vari)i).colornum];
	}
	public String getimm(Imm i) {
		String k="";
		if (i.val>=0) k="+";
		k+=String.valueOf(i.val);
		return k;
	}
	public String getmem(Vari i) {
		String ans;
		if(isConststring(i)) {
			ans=i.name;
		}
		else if(isResarea(i)) {
			ans="qword["+i.name+"]";
		}
		else {
			ans="qword[rbp"+getimm(((Temp)i).offset)+"]";
		}
		return ans;
	}
	public void saveregs() {
		savereg(0);
		savereg(2);
		savereg(3);
	}
	public void savereg(int k) {
		if (regvar[k]==null) return;
		if (!isImm(regvar[k])&&!isMem(regvar[k])) {
			Vari var=(Vari)regvar[k];
			mov(getmem(var),var.tempreg);
			var.tempreg=null;
			regvar[k]=null;
			usage[k]=false;
		}
	}
/*	public void savevari(Vari var) {
		if (var.reg==null) return;
		if (isResarea(var)) {
			nasmlist.add("mov\tqword ["+var.name+"] , "+var.reg);
		}
		else if(isTemp(var)) {
			nasmlist.add("mov\tqword [rbp"+getimm(((Temp)var).offset)+"] , "+var.reg);
		}
		regvar[regint.get(var.reg)]=null;
		var.reg=null;
	}
	public void putvar(Var var,int k) {
		usage[k]=true;
		if (isImm(var)) {
			nasmlist.add("mov\t"+regname[k]+" , "+getimm((Imm)var));
			return;
		}
		else if(isMem(var)) {
			nasmlist.add("mov\t"+regname[k]+" , "+getmem((Mem)var));
			return;
		}
		Vari var2=(Vari) var;
		var2.reg=regname[k];
		regvar[k]=var;
		nasmlist.add("mov\t"+regname[k]+", "+getmem(var2));		
	}
	public void setvar(Var var,int k) {
		usage[k]=true;
		if (isImm(var)) {
			return;
		}
		else if(isMem(var)) {
			return;
		}
		Vari var2=(Vari) var;
		var2.reg=regname[k];
		regvar[k]=var;
	}
	int k=0;
	public void resetregs() {
		for (int i=0;)
	}
	public String regassign(Var i,boolean h) {
		if (!isImm(i) && !isMem(i)) {
			if (((Vari)i).reg!=null)
				return ((Vari)i).reg;
		}
		if (usageque.size()<11) {
			for(int i1=0;i1<16;++i1) {
				if (!usage[i1]) {
					boolean h=false;
					for (Integer j:usageque) {
						if (j==i1) h=true;
					}
					if (h) continue;
					usageque.addLast(i1);
					putvar(i,i1);
					return regname[i1];
				}
			}
		}
		int k=usageque.pollFirst();
		usageque.add(k);
		if (regvar[k]!=null && !isImm(regvar[k])  ) {
			Vari var=(Vari)regvar[k];
			savevari(var);
		}
		putvar(i,k);
		return regname[k];
		if (h) {
		++k;
		k%=3;
		if (k==0) {
			savereg(1);
			putvar(i,1);
			return "rbx";
		}
		else if(k==1) {
			savereg(14);
			putvar(i,14);
			return "r14";
		}
		else {
			savereg(15);
			putvar(i,15);
			return "r15";
		}
		}
		else {
			++k;
			k%=3;
			if (k==0) {
				savereg(1);
				setvar(i,1);
				return "rbx";
			}
			else if(k==1) {
				savereg(14);
				setvar(i,14);
				return "r14";
			}
			else {
				savereg(15);
				setvar(i,15);
				return "r15";
			}
		}
	}*/
	public String reg(int i) {
		return regname[i];
	}
	public void mov(String a,String b) {
		if (!a.equals(b))
			nasmlist.add("mov\t"+a+" , "+b);
	}
	public String tempreg(Var t,int k) throws SemeticError {
		if (k!=0 && k!=2 && k!=3) throw new SemeticError();
		if (isMem(t)||isImm(t)) {
			mov(regname[k],getname(t));
			t.tempreg=regname[k];
			regvar[k]=t;
			return t.tempreg;
		}
		Vari tp=(Vari) t;
		if (tp.colornum!=-1) t.tempreg=getname(t);
		else if (t.tempreg==null){
			mov(regname[k],getname(t));
			t.tempreg=regname[k];
			regvar[k]=t;
		}
		return t.tempreg;
	}
	public String getmem(Mem i) throws SemeticError {
		String ans="qword[";
		tempreg(i.pos,3);
		ans+=i.pos.tempreg;
		if (i.varoff!=null) {
			ans+="+";
			tempreg(i.varoff,2);
			ans+=i.varoff.tempreg;
			ans+="*"+String.valueOf(i.scale);
		}
		if (i.offset!=null) {
			ans+=getimm(i.offset);
		}
		ans+="]";
		return ans;
	}
	public String length(String i) {
		int k=i.length();
		String ans=String.valueOf(k);
		ans+=",0x00,0x00,0x00,0x00,0x00,0x00,0x00,";
		return ans;
	}
	public void make() throws SemeticError {
		Stack<String> callersave=new Stack<>();
		Stack<String> calleesave=new Stack<>();
		Stack<Var> param=new Stack<>();
		for (String i:global) {
			nasmlist.add("global "+i);
		}
		nasmlist.add("SECTION .data\t");
		for (Conststring i:contoplist) {
			nasmlist.add(i.name+":");
			ArrayList<Integer> converter=new ArrayList<>();
			boolean flag=false;
			for (int j=0;j<i.val.length();++j) {
				if (flag==false) {
					char c=(i.val).charAt(j);
					if (c!='\\')
							converter.add((int) c);
					else flag=true;
				}
				else {
					char c=(i.val).charAt(j);
					if (c=='n') converter.add(10);
					else converter.add((int)c);
					flag=false;
				}
			}
			String ans;
			ans="db\t"+String.valueOf(converter.size());
			ans+=",0x00,0x00,0x00,0x00,0x00,0x00,0x00,";
			for (int j=0;j<converter.size();++j)
				ans+=(String.valueOf(converter.get(j))+",");
			nasmlist.add(ans+"0");
		}
		nasmlist.add("SECTION .bss\t");
		for (Resarea i:restoplist) {
			nasmlist.add(i.name+":");
			nasmlist.add("resq\t1");
		}
		nasmlist.add("SECTION .text");
		for (int i=0;i<quadlist.size();++i) {
			Quad inst=quadlist.get(i);
			if (isAssign(inst)) {
				AssignQuad ass=(AssignQuad)(inst);
				if (isMem(ass.lhs)) {
					if(isImm(ass.rhs)) mov(getmem((Mem)ass.lhs),getimm((Imm)ass.rhs));
					else {
						Vari a=(Vari)ass.rhs;
						tempreg(a,0);
						mov(getmem((Mem)ass.lhs),a.tempreg);
					}
				}
				else if(isResarea(ass.lhs)) {
					if(isImm(ass.rhs)) mov(getmem((Resarea)ass.lhs),getimm((Imm)ass.rhs));
					else {
						Vari a=(Vari)ass.rhs;
						tempreg(a,0);
						mov(getmem((Resarea)ass.lhs),a.tempreg);
					}
				}
				else{
					Vari l=(Vari)ass.lhs;
					tempreg(l, 0);
					mov(l.tempreg,getname(ass.rhs));
				}
				saveregs();
			}
			else if (isBinary(inst)) {
				BinaryQuad bin=(BinaryQuad)inst;
				Vari l=bin.vardest;
				tempreg(l,0);
				String var2;
				var2=getname(bin.var2);
				if (bin.var1!=bin.vardest) {
					mov(l.tempreg,getname(bin.var1));
				}
				
				if (bin.op.equals("/")||bin.op.equals("%")) {
					if (!l.tempreg.equals("rax"))
						mov("rax",l.tempreg);
					nasmlist.add("cqo");
					tempreg(bin.var2,2);
					Unary("idiv",bin.var2.tempreg);
					if (bin.op.equals("/"))
						mov(l.tempreg,"rax");
					else mov(l.tempreg,"rdx");
				}
				else if(bin.op.equals("<")) {
					Binary("cmp",l.tempreg,var2);
					mov("rax","0");
					Unary("setl","al");
					mov(l.tempreg,"rax");
				}
				else if(bin.op.equals("<=")) {
					Binary("cmp",l.tempreg,var2);
					mov("rax","0");
					Unary("setle","al");
					mov(l.tempreg,"rax");
				}
				else if(bin.op.equals(">")) {
					Binary("cmp",l.tempreg,var2);
					mov("rax","0");
					Unary("setg","al");
					mov(l.tempreg,"rax");
				}
				else if(bin.op.equals(">=")) {
					Binary("cmp",l.tempreg,var2);
					mov("rax","0");
					Unary("setge","al");
					mov(l.tempreg,"rax");
				}
				else if(bin.op.equals("==")) {
					Binary("cmp",l.tempreg,var2);
					mov("rax","0");
					Unary("sete","al");
					mov(l.tempreg,"rax");
				}
				else if(bin.op.equals("!=")) {
					Binary("cmp",l.tempreg,var2);
					mov("rax","0");
					Unary("setne","al");
					mov(l.tempreg,"rax");
				}
				else if(bin.op.equals(">>")) {
					mov("rcx",var2);
					Binary("sar",l.tempreg,"cl");
				}
				else if(bin.op.equals("<<")) {
					mov("rcx",var2);
					Binary("sal",l.tempreg,"cl");
				}
				else {
					String op="";
					if (bin.op.equals("+")) op="add";
					else if (bin.op.equals("-")) op="sub";
					else if (bin.op.equals("*")) op="imul";
					else if (bin.op.equals("&")||bin.op.equals("&&")) op="and";
					else if (bin.op.equals("|")||bin.op.equals("||")) op="or";
					else if (bin.op.equals("^")) op="xor";
					Binary(op,l.tempreg,var2);
				}
				saveregs();
			}
			else if (isCJump(inst)) {
				CJumpQuad cj=(CJumpQuad)inst;
				if (isImm(cj.par)) 
				Binary("cmp",tempreg(cj.par,0),"0");
				else Binary("cmp",getname(cj.par),"0");
				saveregs();
				if (cj.Truelab!=null)
					Unary("jne",cj.Truelab.label);
				if (cj.Falselab!=null)
					Unary("je",cj.Falselab.label);
			}
			else if (isJump(inst)) {
				Unary("jmp",((JumpQuad)inst).label.label);
			}
			else if (isUniary(inst)) {
				UniQuad uni=(UniQuad)(inst);
				tempreg(uni.dest,0);
				if (uni.op.equals("~")) {
					mov(uni.dest.tempreg,getname(uni.src));
					Unary("not",uni.dest.tempreg);
				}
				else if (uni.op.equals("-")) {
					mov(uni.dest.tempreg,getname(uni.src));
					Unary("neg",uni.dest.tempreg);
				}
				else if (uni.op.equals("!")) {
					mov(uni.dest.tempreg,"1");
					Binary("sub",uni.dest.tempreg,getname(uni.src));
				}
				saveregs();
			}
			else if(isLabel(inst)) {
				nasmlist.add(((Label)inst).label+":");
				if (inst.functionhead) {
					init();
					calleesave=new Stack<>();
					Function nowfunc=lab2fun.get((Label)inst);
					Unary("push","rbp");
					mov("rbp","rsp");
					Binary("sub","rsp",String.valueOf(nowfunc.templong));
					List<Temp> temp=lab2fun.get((Label)inst).temps;
					Label ins=(Label) inst;
					for (int j=0;j<16;++j) {
						if (ins.usedreg[j]) {
							calleesave.push(regname[j]);
							Unary("push",regname[j]);
						}
					}
					for (int j=0;j<temp.size();++j) {
						if (j==0) mov(getname(temp.get(j)),"rdi");//{setvar(temp.get(j), 5);usageque.add(5);}
						if (j==1) mov(getname(temp.get(j)),"rsi");//{setvar(temp.get(j), 4);usageque.add(4);}
						if (j==2) mov(getname(temp.get(j)),"rdx");//{mov(getname(temp.get(j)),"rdx");}
						if (j==3) mov(getname(temp.get(j)),"rcx");//{mov(getname(temp.get(j)),"rcx");}
						if (j==4) mov(getname(temp.get(j)),"r8");//{setvar(temp.get(j), 8);usageque.add(8);}
						if (j==5) mov(getname(temp.get(j)),"r9");//{setvar(temp.get(j), 9);usageque.add(9);}
						if (j>=6) mov(getname(temp.get(j)),getmem(temp.get(j)));
					}
/*					if (j<1) {
						calleesave.push("rdi");
						Unary("push","rdi");
					}
					if (j<2) {
						calleesave.push("rsi");
						Unary("push","rsi");
					}
					if (j<5) {
						calleesave.push("r8");
						Unary("push","r8");
					}
					if (j<6) {
						calleesave.push("r9");
						Unary("push","r9");
					}*/
				}
				else {
				}
			}
			else if(isParam(inst)) {
				param.add(((Param)inst).param);
			}
			else if(isCall(inst)) {
				Call cl=(Call)inst;
				Unary("push","rdi");callersave.push("rdi");
				Unary("push","rsi");callersave.push("rsi");
				Unary("push","r8");callersave.push("r8");
				Unary("push","r9");callersave.push("r9");
				Unary("push","r10");callersave.push("r10");
				Unary("push","r11");callersave.push("r11");
				for (int j=cl.num;j>0;--j) {
					if (j>6) {
						Unary("push",getname(param.pop()));
					}
					else {
						String x=getname(param.pop());
						if (j==6 && !x.equals("r9")) mov("r9",x);
						if (j==5 && !x.equals("r8")) mov("r8",x);
						if (j==4) mov("rcx",x);
						if (j==3) mov("rdx",x);
						if (j==2 && !x.equals("rsi")) mov("rsi",x);
						if (j==1 && !x.equals("rdi")) mov("rdi",x);
					}
				}
				Unary("call",cl.fun);
				if (cl.num>6)
					Binary("add","rsp",String.valueOf((cl.num-6)*8));
				while (callersave.size()>0) {
					Unary("pop",callersave.pop());
				}
				if (cl.retval!=null)
					mov(getname(cl.retval),"rax");
				saveregs();
			}
			else if(isMalloc(inst)) {
				Unary("push","rdi");callersave.push("rdi");
				Unary("push","rsi");callersave.push("rsi");
				Unary("push","rdx");callersave.push("rdx");
				Unary("push","rcx");callersave.push("rcx");
				Unary("push","r8");callersave.push("r8");
				Unary("push","r9");callersave.push("r9");
				Unary("push","r10");callersave.push("r10");
				Unary("push","r11");callersave.push("r11");
				mov("rdi",getname(((MallocQuad)inst).size));
				Unary("call","malloc");
				while (callersave.size()>0) {
					Unary("pop",callersave.pop());
				}
				mov(getname(((MallocQuad)inst).dest),"rax");
			}
			else if(isReturn(inst)) {
				Return ret=(Return)inst;
				if (ret.ret!=null)
					mov("rax",getname(ret.ret));
				for (int j=calleesave.size()-1;j>=0;--j) {
					Unary("pop",calleesave.get(j));
				}
				nasmlist.add("leave");
				nasmlist.add("ret");
			}
	}
}
}
