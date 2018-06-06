package IR;

import java.util.HashSet;
import java.util.Set;

public class Temp extends Vari {
	public Temp(String name, Imm offset) {
		super();
		this.name = name;
		this.offset = offset;
		intsect=new HashSet<>();
	}
	public int nebs=0;
	public Set<Temp> intsect;
	public Imm offset; //frombp
}
