package compilerNode;

public class Localvaridecnode extends node {
	public Typenode type;
	public Vardeclaratorsnode id;
	
	public Localvaridecnode(Typenode type, Vardeclaratorsnode id) {
		super();
		this.type = type;
		this.id = id;
	}
	public Localvaridecnode() {
		super();
	}
	
}
