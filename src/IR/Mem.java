package IR;

public class Mem extends Var {
	public Vari pos;
	public Vari varoff;
	public int scale;
	public Imm offset;
	public Mem(Vari pos,Imm offset) {
		super();
		this.pos = pos;
		this.offset=offset;
	}
	public Mem() {
		super();
	}
	public Mem(Vari pos) {
		super();
		this.pos = pos;
	}
}
