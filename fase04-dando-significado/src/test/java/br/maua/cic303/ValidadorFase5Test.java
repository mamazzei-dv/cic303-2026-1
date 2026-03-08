package br.maua.cic303;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;
import br.maua.cic303.ast.ASTNode;

public class ValidadorFase5Test {

    private ASTNode compilarParaAST(String codigo) throws Exception {
        Lexer lexer = new Lexer(new StringReader(codigo));
        parser parser1 = new parser(lexer);
        parser1.parse();
        return parser1.root; // Captura a raiz salva no passo 1 do CUP
    }

    @Test
    public void test01_AtribuicaoENumeros() throws Exception {
        ASTNode ast = compilarParaAST("taxa = 15.5 ;");
        assertNotNull("A AST não pode ser nula", ast);

        // Espera-se um BLOCK contendo 1 comando de Atribuição
        String arvoreEsperada = "BLOCK[ASSIGN(taxa, 15.5)]";
        assertEquals("Erro na estrutura da AST para atribuição.", arvoreEsperada, ast.toString());
    }

    @Test
    public void test02_PrecedenciaNaAST() throws Exception {
        ASTNode ast = compilarParaAST("resultado = 2 + 3 * 4 ;");

        // A multiplicação deve estar "abaixo" da soma na árvore
        String arvoreEsperada = "BLOCK[ASSIGN(resultado, +(2.0, *(3.0, 4.0)))]";
        assertEquals("A AST gerou a precedência matemática errada (Shift/Reduce resolvido errado?).",
                arvoreEsperada, ast.toString());
    }

    @Test
    public void test03_MultiplosComandos() throws Exception {
        ASTNode ast = compilarParaAST("x = 1; y = x + 2;");

        String arvoreEsperada = "BLOCK[ASSIGN(x, 1.0), ASSIGN(y, +(x, 2.0))]";
        assertEquals("Erro ao agrupar múltiplos comandos no stmt_list.", arvoreEsperada, ast.toString());
    }
}