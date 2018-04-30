package visitor;

import java.util.Map;

import type.Function;
import type.definedtype;

public class TopScope extends Scope {
	public Map<String,Function> topfuncs;
	public Map<String,definedtype> classtype;
}
