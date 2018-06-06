package IR;

import java.util.*;

public class Call extends Quad {
	public Vari retval;
	public String fun;
	public int num;
	public Call(Vari val,String fun, int num) {
		super();
		retval=val;
		this.fun = fun;
		this.num = num;
	}
	
}
