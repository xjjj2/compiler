package IR;

public class Temp extends Vari {
	public Temp(String name, Imm offset) {
		super();
		this.name = name;
		this.offset = offset;
	}
	public Imm offset; //frombp
}
