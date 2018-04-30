package Error;

public class SemeticError extends Throwable {
	public String type;

	public SemeticError(String type) {
		super();
		this.type = type;
	}

	public SemeticError() {
		super();
	}
	
}
