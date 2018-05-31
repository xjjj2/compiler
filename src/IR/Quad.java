package IR;
import type.*;
public abstract class Quad {
	public Quad prev;
	public Quad next;
	public boolean functionhead;
	Quad(){
		functionhead=false;
	}
}
