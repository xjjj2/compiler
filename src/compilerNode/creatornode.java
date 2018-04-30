package compilerNode;

public class creatornode extends node {
	public creatednamenode name;
	public createdrestnode createrest;
	public creatornode(creatednamenode name, createdrestnode createrest) {
		super();
		this.name = name;
		this.createrest = createrest;
	}
	public creatornode() {
		super();
	}
	
}
