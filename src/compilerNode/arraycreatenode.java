package compilerNode;
import java.util.*;
public class arraycreatenode extends createdrestnode {
	public List<Exprnode> exprs;
	public int num;
	public arraycreatenode(List<Exprnode> exprs) {
		super();
		this.exprs = exprs;
	}
	public arraycreatenode() {
		super();
		exprs=new ArrayList<Exprnode>();
	}
	
}
