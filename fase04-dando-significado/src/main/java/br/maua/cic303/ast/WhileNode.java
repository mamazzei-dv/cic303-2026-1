package br.maua.cic303.ast;

/**
 * Nó da AST que representa uma estrutura de repetição (while).
 */
public class WhileNode extends ASTNode {
    public final ASTNode condicao;
    public final ASTNode bloco;

    public WhileNode(ASTNode condicao, ASTNode bloco) {
        this.condicao = condicao;
        this.bloco = bloco;
    }

    @Override
    public String toString() {
        return "WHILE(" + condicao + ", DO(" + bloco + "))";
    }
}