package IR;

import java.util.*;

public class Label extends Quad {
	public String label;
	public boolean usedreg[];
	public Set<Temp> usedtemp;
	public Label(String label) {
		super();
		usedtemp=new HashSet<>();
		this.label = label;
		usedreg=new boolean[16];
		for (int i=0;i<16;++i) {
			usedreg[i]=false;
		}
	}
	
}
