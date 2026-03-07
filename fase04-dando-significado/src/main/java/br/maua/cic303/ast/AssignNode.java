package main.java.br.maua.cic303.ast;

public class AssignNode extends ASTNode {
    public final IdentifierNode id;
    public final ASTNode expr;

    public AssignNode(IdentifierNode id, ASTNode expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "ASSIGN(" + id + ", " + expr + ")";
    }
}