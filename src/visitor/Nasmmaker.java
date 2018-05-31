package visitor;
import java.util.*;
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
	public String getname(Var i) {
		if (isImm(i)) {
			return getimm((Imm)i);
		}
		if (isMem(i)) {
			return getmem((Mem)i);
		}
		if (((Vari)i).reg==null) 
			return getmem((Vari)i);
		return ((Vari)i).reg;
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
	public void savevari(Vari var) {
		if (isResarea(var)) {
			nasmlist.add("mov\tqword ["+var.name+"] , "+var.reg);
		}
		else if(isTemp(var)) {
			nasmlist.add("mov\tqword [rbp"+getimm(((Temp)var).offset)+"] , "+var.reg);
		}
		regvar[regint.get(var.reg)]=null;
		var.reg=null;
	}
	public void savereg(int k) {
		if (regvar[k]==null) return;
		if (!isImm(regvar[k])&&!isMem(regvar[k])) {
			Vari var=(Vari)regvar[k];
			mov(getmem(var),var.reg);
			var.reg=null;
			regvar[k]=null;
			usage[k]=false;
		}
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
	public String regassign(Var i) {
		if (!isImm(i) && !isMem(i)) {
			if (((Vari)i).reg!=null)
				return ((Vari)i).reg;
		}
		if (usageque.size()<11) {
			for(int i1=0;i1<16;++i1) {
				if (!usage[i1]) {
					usageque.addLast(i1);
					putvar(i,i1);
					return regname[i1];
				}
			}
		}
		int k=usageque.pollFirst();
		usageque.add(k);
		if (!isImm(regvar[k]) && regvar[k]!=null) {
			Vari var=(Vari)regvar[k];
			savevari(var);
		}
		putvar(i,k);
		return regname[k];
	}
	public void mov(String a,String b) {
		nasmlist.add("mov\t"+a+" , "+b);
	}
	public String getmem(Mem i) {
		String ans="qword[";
		ans+=i.pos.reg;
		if (i.varoff!=null) {
			ans+="+";
			ans+=i.varoff.reg;
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
		String ans="0x00000000000000,";
		ans+=String.valueOf(k);
		ans+=",";
		return ans;
	}
	public void make() {
		Stack<String> callersave=new Stack<>();
		Stack<String> calleesave=new Stack<>();
		Stack<Var> param=new Stack<>();
		for (String i:global) {
			nasmlist.add("global "+i);
		}
		nasmlist.add("SECTION .data\t");
		for (Conststring i:contoplist) {
			nasmlist.add(i.name+":");
			nasmlist.add("db\t"+length(i.val)+"\""+i.val+"\""+",0");
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
						if (a.reg==null) {
							mov(getmem((Mem)ass.lhs),regassign(a));
						}
						else {
							mov(getmem((Mem)ass.lhs),a.reg);
						}
					}
				}
				else if(isResarea(ass.lhs)) {
					if(isImm(ass.rhs)) mov(getmem((Resarea)ass.lhs),getimm((Imm)ass.rhs));
					else {
						Vari a=(Vari)ass.rhs;
						if (a.reg==null) {
							mov(getmem((Resarea)ass.lhs),regassign(a));
						}
						else {
							mov(getmem((Resarea)ass.lhs),a.reg);
						}
					}
				}
				else{
					Vari l=(Vari)ass.lhs;
					if (l.reg==null) regassign(l);
					if (isImm(ass.rhs)) mov(l.reg,getimm((Imm)ass.rhs));
					else if(isMem(ass.rhs)) mov(l.reg,getmem((Mem)ass.rhs));
					else {
						Vari r=(Vari)ass.rhs;
						if (r.reg==null) {
							mov(l.reg,getmem(r));
						}
						else {
							mov(l.reg,r.reg);
						}
					}
				}
			}
			else if (isBinary(inst)) {
				BinaryQuad bin=(BinaryQuad)inst;
				Vari l=bin.vardest;
				if (bin.vardest.reg==null) regassign(bin.vardest);
				if (bin.var1!=bin.vardest) {
					if (isImm(bin.var1)) mov(l.reg,getimm((Imm)bin.var1));
					else if(isMem(bin.var1)) mov(l.reg,getmem((Mem)bin.var1));
					else {
						Vari r=(Vari)bin.var1;
						if (r.reg==null) {
						mov(l.reg,getmem(r));
					}
					else {
						mov(l.reg,r.reg);
					}
					}
				}
				String var2;
				if (isImm(bin.var2)) var2=getimm((Imm)bin.var2);
				else if(isMem(bin.var2)) var2=getmem((Mem)bin.var2);
				else {
					Vari r=(Vari)bin.var2;
					if (r.reg==null) {
					var2=getmem(r);
				}
				else {
					var2=r.reg;
				}
				if (bin.op.equals("/")||bin.op.equals("%")) {
					mov("rax",l.reg);
					Unary("idiv",regassign(bin.var2));
					if (bin.op.equals("/"))
						mov(l.reg,"rax");
					else mov(l.reg,"rdx");
				}
				else if(bin.op.equals("<")) {
					Binary("cmp",l.reg,var2);
					mov("rax","0");
					Unary("setl","al");
					mov(l.reg,"rax");
				}
				else if(bin.op.equals("<=")) {
					Binary("cmp",l.reg,var2);
					mov("rax","0");
					Unary("setle","al");
					mov(l.reg,"rax");
				}
				else if(bin.op.equals(">")) {
					Binary("cmp",l.reg,var2);
					mov("rax","0");
					Unary("setg","al");
					mov(l.reg,"rax");
				}
				else if(bin.op.equals(">=")) {
					Binary("cmp",l.reg,var2);
					mov("rax","0");
					Unary("setge","al");
					mov(l.reg,"rax");
				}
				else if(bin.op.equals("==")) {
					Binary("cmp",l.reg,var2);
					mov("rax","0");
					Unary("sete","al");
					mov(l.reg,"rax");
				}
				else if(bin.op.equals("!=")) {
					Binary("cmp",l.reg,var2);
					mov("rax","0");
					Unary("setne","al");
					mov(l.reg,"rax");
				}
				else if(bin.op.equals(">>")) {
					mov("rcx",var2);
					Binary("sar",l.reg,"cl");
				}
				else if(bin.op.equals("<<")) {
					mov("rcx",var2);
					Binary("sal",l.reg,"cl");
				}
				else {
					String op="";
					if (bin.op.equals("+")) op="add";
					else if (bin.op.equals("-")) op="sub";
					else if (bin.op.equals("*")) op="imul";
					else if (bin.op.equals("&")||bin.op.equals("&&")) op="and";
					else if (bin.op.equals("|")||bin.op.equals("||")) op="or";
					else if (bin.op.equals("^")) op="xor";
					Binary(op,l.reg,var2);
				}
			}
		}
			else if (isCJump(inst)) {
				CJumpQuad cj=(CJumpQuad)inst;
				Binary("cmp",getname(cj.par),"0");
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
				regassign(uni.dest);
				if (uni.op.equals("~")) {
					mov(uni.dest.reg,getname(uni.src));
					Unary("not",uni.dest.reg);
				}
				else if (uni.op.equals("-")) {
					mov(uni.dest.reg,getname(uni.src));
					Unary("neg",uni.dest.reg);
				}
				else if (uni.op.equals("!")) {
					mov(uni.dest.reg,"1");
					Binary("sub",uni.dest.reg,getname(uni.src));
				}
			}
			else if(isLabel(inst)) {
				nasmlist.add(((Label)inst).label+":");
				if (inst.functionhead) {
					init();
					Function nowfunc=lab2fun.get((Label)inst);
					Unary("push","rbp");
					mov("rbp","rsp");
					Binary("sub","rsp",String.valueOf(nowfunc.templong));
					List<Temp> temp=lab2fun.get((Label)inst).temps;
					for (int j=0;j<temp.size();++j) {
						if (j==0) {putvar(temp.get(j), 5);usageque.add(5);}
						if (j==1) {putvar(temp.get(j), 4);usageque.add(4);}
						if (j==2) {mov(getname(temp.get(j)),"rdx");}
						if (j==3) {mov(getname(temp.get(j)),"rcx");}
						if (j==4) {putvar(temp.get(j), 8);usageque.add(8);}
						if (j==5) {putvar(temp.get(j), 9);usageque.add(9);}
					}
					int j=temp.size();
					calleesave.push("rbx");
					Unary("push","rbx");
					for (int k=10;k<16;++k) {
						calleesave.push(regname[k]);
						Unary("push",regname[k]);
					}
					if (j<1) {
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
					}
				}
			}
			else if(isParam(inst)) {
				param.add(((Param)inst).param);
			}
			else if(isCall(inst)) {
				Call cl=(Call)inst;
				if (regvar[5]!=null) {Unary("push","rdi");callersave.push("rdi");}
				if (regvar[4]!=null) {Unary("push","rsi");callersave.push("rsi");}
				if (regvar[8]!=null) {Unary("push","r8");callersave.push("r8");}
				if (regvar[9]!=null) {Unary("push","r9");callersave.push("r9");}
				if (regvar[10]!=null) {Unary("push","r10");callersave.push("r10");}
				if (regvar[11]!=null) {Unary("push","r11");callersave.push("r11");}
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
					mov(regassign(cl.retval),"rax");
			}
			else if(isMalloc(inst)) {
				if (regvar[5]!=null) {Unary("push","rdi");callersave.push("rdi");}
				if (regvar[10]!=null) {Unary("push","r10");callersave.push("r10");}
				if (regvar[11]!=null) {Unary("push","r11");callersave.push("r11");}
				mov("rdi",getname(((MallocQuad)inst).size));
				Unary("call","malloc");
				while (callersave.size()>0) {
					Unary("pop",callersave.pop());
				}
			}
			else if(isReturn(inst)) {
				Return ret=(Return)inst;
				if (ret.ret!=null)
					mov("rax",getname(ret.ret));
				while (calleesave.size()>0) {
					Unary("pop",calleesave.pop());
				}
				nasmlist.add("leave");
				nasmlist.add("ret");
			}
	}
}
}
