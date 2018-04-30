package compilerNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;
public class SourcePosition {
	public final int line;
    public final int column;

    public SourcePosition(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public SourcePosition(Token token) {
        this.line = token.getLine();
        this.column = token.getCharPositionInLine();
    }

    public SourcePosition(ParserRuleContext ctx) {
        this(ctx.start);
    }

    public SourcePosition(TerminalNode terminal) {
        this(terminal.getSymbol());
    }

    @Override
    public String toString() {
        return "Line " + line + " Column " + column;
    }
}
