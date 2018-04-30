package compilerNode;
import java.util.List;
public class formalparalistnode extends node{
	public List<formalparanode> para;

	public List<formalparanode> getPara() {
		return para;
	}

	public void setPara(List<formalparanode> para) {
		this.para = para;
	}

	public formalparalistnode(List<formalparanode> para) {
		super();
		this.para = para;
	}

	public formalparalistnode() {
		super();
	}
	
}
