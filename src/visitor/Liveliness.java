package visitor;

import java.util.*;
import IR.*;
public class Liveliness {
	public List<Quad> quadlist;
	public Stack<Var> param=new Stack<>(); 
	public List<Temp> tempset;
	final int colornum=11;
	public int regint[]= {1,4,5,8,9,10,11,12,13,14,15};
	public Liveliness(List<Quad> quadlist, List<Temp> tempset) {
		super();
		this.quadlist = quadlist;
		this.tempset = tempset;
	}
	public void color(Temp t) {
		boolean b[];
		b=new boolean[colornum];
		for (int i=0;i<colornum;++i) b[i]=false;
		for (Temp i:t.intsect) {
			if (i.colornum!=-1) {
				b[i.colornum]=true;
			}
		}
		for (int i=0;i<colornum;++i) {
			if (!b[i]) {
				t.colornum=i;
				break;
			} 
		}
	}
	public void color_full(Temp t) {
		boolean b[];
		b=new boolean[colornum];
		for (int i=0;i<colornum;++i) b[i]=false;
		for (Temp i:tempset) {
			if (i.colornum!=-1) {
				b[i.colornum]=true;
			}
		}
		for (int i=0;i<colornum;++i) {
			if (!b[i]) {
				t.colornum=i;
				break;
			} 
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
	public void liveliness() {
		for (int i=0;i<quadlist.size();++i) {
			Quad inst=quadlist.get(i);
			if (isAssign(inst)) {
				AssignQuad ins=(AssignQuad) inst;
				if(isTemp(ins.lhs)) ins.def.add((Temp) ins.lhs);
				if(isTemp(ins.rhs)) ins.use.add((Temp) ins.rhs);
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.pred.add(ins);
				}
			}
			else if (isBinary(inst)) {
				BinaryQuad ins=(BinaryQuad) inst;
				if(isTemp(ins.vardest)) ins.def.add((Temp) ins.vardest);
				if(isTemp(ins.var1)) ins.use.add((Temp) ins.var1);
				if(isTemp(ins.var2)) ins.use.add((Temp) ins.var2);
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.succ.add(ins);
				}
			}
			else if (isCall(inst)) {
				Call ins=(Call) inst;
				for (int j=0;j<ins.num;++j) {
					Var t=param.pop();
					if (isTemp(t)){
						ins.use.add((Temp) t);
					}
				}
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.succ.add(ins);
				}
			}
			else if(isCJump(inst)) {
				CJumpQuad ins=(CJumpQuad) inst;
				if (isTemp(ins.par))
					ins.use.add((Temp) ins.par);
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.succ.add(ins);
				}
				if (ins.Truelab!=null) {
					ins.succ.add(ins.Truelab);
					ins.Truelab.succ.add(ins);
				}
				if (ins.Falselab!=null) {
					ins.succ.add(ins.Falselab);
					ins.Falselab.succ.add(ins);
				}
			}
			else if(isJump(inst)) {
				JumpQuad ins=(JumpQuad) inst;
				ins.succ.add(ins.label);
				ins.label.succ.add(ins);
			}
			else if(isLabel(inst)) {
				Label ins=(Label) inst;
				if (inst.functionhead) {
					
				}
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.succ.add(ins);
				}
			}
			else if(isMalloc(inst)) {
				MallocQuad ins=(MallocQuad) inst;
				if (isTemp(ins.dest))
					inst.def.add((Temp) ins.dest);
				if (isTemp(ins.size))
					inst.use.add((Temp) ins.size);
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.succ.add(ins);
				}
			}
			else if(isParam(inst)) {
				Param ins=(Param) inst;
				param.add(ins.param);
				if (inst.prev!=null) {
					inst.succ.add(inst.prev);
					inst.prev.succ.add(inst);
				}
			}
			else if(isReturn(inst)) {
				Return ins=(Return) inst;
				if (ins.ret!=null && isTemp(ins.ret)) {
					inst.use.add((Temp) ins.ret);
				}
			}
			else if(isUniary(inst)) {
				UniQuad ins=(UniQuad) inst;
				if(isTemp(ins.dest)) ins.def.add((Temp) ins.dest);
				if(isTemp(ins.src)) ins.use.add((Temp) ins.src);
				if (ins.prev!=null) {
					ins.succ.add(ins.prev);
					ins.prev.succ.add(ins);
				}
			}
		}
		boolean h=true;
		while (h) {
			h=false;
			for (int i=quadlist.size()-1;i>=0;--i) {
				Quad inst=quadlist.get(i);
				int t1=inst.in.size();
				int t2=inst.out.size();
				for (Quad s:inst.succ) inst.out.addAll(s.in);
				inst.in.addAll(inst.use);
				for (Temp t:inst.out) {
					if (!inst.def.contains(t)) {
						inst.in.add(t);
					}
				}
				if (t1!=inst.in.size()||t2!=inst.out.size()) h=true;
			}
		}
		for (int i=0;i<quadlist.size();++i) {
			Quad inst=quadlist.get(i);
			if (!isAssign(inst)) {
				for (Temp a:inst.def){
					a.intsect.addAll(inst.out);
				}
			}
			else {
				AssignQuad ins=(AssignQuad) inst;
				for (Temp a:inst.def) {
					for (Temp b:inst.out)
						if (ins.rhs!=b) a.intsect.add(b);
				}
			}
		}
		Collections.shuffle(tempset);
		for (int i=0;i<tempset.size();++i) {
			Temp t=tempset.get(i);
			color_full(t);
		}
		for (int i=0;i<tempset.size();++i) {
			Temp t=tempset.get(i);
			if (t.colornum!=-1)
				t.colornum=regint[t.colornum];
		}
		for (int i=0;i<quadlist.size();++i) {
			if (!isLabel(quadlist.get(i))) continue;
			Label inst=(Label) quadlist.get(i);
			if (inst.functionhead) {
				for (Temp t:inst.usedtemp) 
					if (t.colornum!=-1)
						inst.usedreg[t.colornum]=true;
			}
		}
	}
}
