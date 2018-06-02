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
	public void saveregs() {
		savereg(1);
		savereg(14);
		savereg(15);
	//	for (int i=8;i<16;++i) savereg(i);
	}
	public void savevari(Vari var) {
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
/*	public void resetregs() {
		for (int i=0;)
	}*/
	public String regassign(Var i,boolean h) {
		if (!isImm(i) && !isMem(i)) {
			if (((Vari)i).reg!=null)
				return ((Vari)i).reg;
		}
/*		if (usageque.size()<11) {
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
		return regname[k];*/
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
	}
	public void mov(String a,String b) {
		nasmlist.add("mov\t"+a+" , "+b);
	}
	public String getmem(Mem i) {
		String ans="qword[";
		if (i.pos.reg==null) regassign(i.pos,true);
		ans+=i.pos.reg;
		if (i.varoff!=null) {
			ans+="+";
			if (i.varoff.reg==null) regassign(i.varoff,true);
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
		String ans=String.valueOf(k);
		ans+=",0x00,0x00,0x00,0x00,0x00,0x00,0x00,";
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
					if (c=='n') converter.add(13);
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
						if (a.reg==null) {
							mov(getmem((Mem)ass.lhs),regassign(a,true));
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
							mov(getmem((Resarea)ass.lhs),regassign(a,true));
						}
						else {
							mov(getmem((Resarea)ass.lhs),a.reg);
						}
					}
				}
				else{
					Vari l=(Vari)ass.lhs;
					if (l.reg==null) regassign(l,false);
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
				saveregs();
			}
			else if (isBinary(inst)) {
				BinaryQuad bin=(BinaryQuad)inst;
				Vari l=bin.vardest;
				if (bin.vardest.reg==null) regassign(bin.vardest,false);
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
				else {
					mov(l.reg,getmem(l));
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
				}
				var2=getname(bin.var2);
				if (bin.op.equals("/")||bin.op.equals("%")) {
					mov("rax",l.reg);
					nasmlist.add("cqo");
					Unary("idiv",regassign(bin.var2,true));
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
				saveregs();
			}
			else if (isCJump(inst)) {
				CJumpQuad cj=(CJumpQuad)inst;
				if (isImm(cj.par)) 
				Binary("cmp",regassign(cj.par,true),"0");
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
				regassign(uni.dest,false);
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
				saveregs();
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
						if (j==0) mov(getname(temp.get(j)),"rdi");//{setvar(temp.get(j), 5);usageque.add(5);}
						if (j==1) mov(getname(temp.get(j)),"rsi");//{setvar(temp.get(j), 4);usageque.add(4);}
						if (j==2) mov(getname(temp.get(j)),"rdx");//{mov(getname(temp.get(j)),"rdx");}
						if (j==3) mov(getname(temp.get(j)),"rcx");//{mov(getname(temp.get(j)),"rcx");}
						if (j==4) mov(getname(temp.get(j)),"r8");//{setvar(temp.get(j), 8);usageque.add(8);}
						if (j==5) mov(getname(temp.get(j)),"r9");//{setvar(temp.get(j), 9);usageque.add(9);}
					}
					int j=temp.size();
					calleesave.push("rbx");
					Unary("push","rbx");
					for (int k=14;k<16;++k) {
						calleesave.push(regname[k]);
						Unary("push",regname[k]);
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
					mov(regassign(cl.retval,false),"rax");
				saveregs();
			}
			else if(isMalloc(inst)) {
				Unary("push","rdi");callersave.push("rdi");
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
				while (calleesave.size()>0) {
					Unary("pop",calleesave.pop());
				}
				nasmlist.add("leave");
				nasmlist.add("ret");
			}
	}
}
}
