package compilerNode;

public class IdentifierNode extends node {
	protected String id;
	public IdentifierNode () {}
	public IdentifierNode(String id) {
		this.id=id;
	}
	public String getId() {
		return id;
	}
}
