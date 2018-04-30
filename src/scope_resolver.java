import java.util.*;
abstract public class Scope {
	protected List<LocalScope> children;
}
class ToplevelScope extends Scope {
	protected Map<String, Entity> entities;
	protected List<DefinedVariable> staticLocalVariables; // cache
}
class LocalScope extends Scope {
	protected Scope parent;
	protected Map<String, DefinedVariable> variables;
}