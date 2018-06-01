package IR;
import java.util.HashSet;
import java.util.Set;

import type.*;
public abstract class Quad {
	public Quad prev;
	public Quad next;
	public Set<Temp> def,use,in,out;
	public Set<Quad> succ;
	public Set<Quad> pred;
	public boolean functionhead;
	Quad(){
		functionhead=false;
		def=new HashSet<>();
		use=new HashSet<>();
		in=new HashSet<>();
		out=new HashSet<>();
		succ=new HashSet<>();
		pred=new HashSet<>();
	}
}
