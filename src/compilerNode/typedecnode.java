package compilerNode;

public class typedecnode extends node {
	public Classdecnode classdec;

	public typedecnode(Classdecnode classdec) {
		super();
		this.classdec = classdec;
	}

	public typedecnode() {
		super();
	}
	
}
