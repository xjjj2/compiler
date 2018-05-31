package IR;

public class MallocQuad extends Quad {
	public Var dest;
	public Var size;
	public MallocQuad(Var dest, Var size) {
		super();
		this.dest = dest;
		this.size = size;
	}
	public MallocQuad() {
		super();
	}
	
}
