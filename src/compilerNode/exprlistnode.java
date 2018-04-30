package compilerNode;
import java.util.*;
public class exprlistnode extends node {
	public List<Exprnode> child;
	public exprlistnode() {}
	public exprlistnode(List<Exprnode> child) {
		this.child=child;
	}
}
