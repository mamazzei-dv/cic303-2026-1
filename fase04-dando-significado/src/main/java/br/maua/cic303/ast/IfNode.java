package br.maua.cic303.ast;

/**
 * Nó da AST que representa uma estrutura de decisão condicional (if-then-else).
 */
public class IfNode extends ASTNode {
    public final ASTNode condicao;
    public final ASTNode blocoVerdadeiro;
    public final ASTNode blocoFalso; // Pode ser null se o 'else' for omitido no código fonte

    public IfNode(ASTNode condicao, ASTNode blocoVerdadeiro, ASTNode blocoFalso) {
        this.condicao = condicao;
        this.blocoVerdadeiro = blocoVerdadeiro;
        this.blocoFalso = blocoFalso;
    }

    @Override
    public String toString() {
        // Se não tiver bloco ELSE, imprime apenas a estrutura IF-THEN
        if (blocoFalso == null) {
            return "IF(" + condicao + ", THEN(" + blocoVerdadeiro + "))";
        }
        // Se tiver bloco ELSE, imprime a estrutura completa
        else {
            return "IF(" + condicao + ", THEN(" + blocoVerdadeiro + "), ELSE(" + blocoFalso + "))";
        }
    }
}