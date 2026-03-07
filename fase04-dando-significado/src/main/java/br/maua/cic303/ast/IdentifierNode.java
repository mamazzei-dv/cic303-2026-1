package main.java.br.maua.cic303.ast;

public class IdentifierNode extends ASTNode {
    public final String name;

    public IdentifierNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}