package main.java.br.maua.cic303.ast;

public class BinOpNode extends ASTNode {
    public final String operator;
    public final ASTNode left, right;

    public BinOpNode(String operator, ASTNode left, ASTNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return operator + "(" + left + ", " + right + ")";
    }
}