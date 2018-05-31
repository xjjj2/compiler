package compilerNode;

import type.definedtype;

public class Thisnode extends Exprnode{
	public String id;
	public definedtype classtype;
	public methoddec linkpos;
	public Thisnode() {id="this";}
}
