package compilerNode;

import java.util.List;

public class Blocknode extends Statementnode {
	public List<Blockstatenode> statements;

	public Blocknode(List<Blockstatenode> statements) {
		super();
		this.statements = statements;
	}

	public Blocknode() {
		super();
	}

	/**
	 * @return the statements
	 */
	public List<Blockstatenode> getStatements() {
		return statements;
	}

	/**
	 * @param statements the statements to set
	 */
	public void setStatements(List<Blockstatenode> statements) {
		this.statements = statements;
	}
	
}
