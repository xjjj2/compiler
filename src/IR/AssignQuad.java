package IR;

public class AssignQuad extends Quad {
	public Var lhs;
	public Var rhs;
	public AssignQuad(Var lhs, Var rhs) {
		super();
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
}
