package ast;

/**
 * @author GAO RISHENG A0101891L
 * This class is mainly in charge of construction of AST nodes and syntax generation for goto
 * statement in C programs
 */
public class ASTGoToStatement extends ASTSimpleStatement {
	ASTExpressionUnitIdentifier label;
	public ASTGoToStatement(ASTExpressionUnitIdentifier label) {
		this.label = label;
		label.addParent(this);
	}
	public String toSyntax(){
		this.result = "goto ";
		this.result+=this.label.toSyntax();
		this.result+=";\n";
		return this.result;
	}

}
