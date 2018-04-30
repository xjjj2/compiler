package compilerNode;

import java.util.*;

public class AstRoot extends node{
	public List<node> childlist;
	public AstRoot ( List<node> child) {
		super();
//		childlist=new node[child.length];
//		System.arraycopy(childlist,0,child,0,child.length);
		childlist=child;
	}
	public AstRoot() {}
	
}
