package compilerNode;
import java.util.List;
public class Classbodynode extends node {
	public List<Classbodydec> statement;

	public Classbodynode(List<Classbodydec> statement) {
		super();
		this.statement = statement;
	}
	public Classbodynode() {
		super();
	}
	
}
