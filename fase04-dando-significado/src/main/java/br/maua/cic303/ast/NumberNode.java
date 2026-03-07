package main.java.br.maua.cic303.ast;

public class NumberNode extends ASTNode {
    public final double value;

    public NumberNode(String valueStr) {
        this.value = Double.parseDouble(valueStr);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}