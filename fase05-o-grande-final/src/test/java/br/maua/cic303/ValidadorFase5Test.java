package br.maua.cic303;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.StringReader;
import br.maua.cic303.ast.ASTNode;

public class ValidadorFase5Test {

    // Roda todo o pipeline do compilador e devolve a memória (Environment) final
    private Environment executarPrograma(String codigo) throws Exception {
        Lexer lexer = new Lexer(new StringReader(codigo));
        parser parser1 = new parser(lexer);
        parser1.parse(); // Fase 3 e 4: Gera a AST

        ASTNode root = parser1.root;
        Environment env = new Environment(); // Fase 5: Cria a memória

        root.avaliar(env); // Fase 5: Executa o programa!
        return env;
    }

    @Test
    public void test01_MatematicaBasica() throws Exception {
        Environment env = executarPrograma("resultado = (10 + 5) * 2 - 4 / 2 ;");

        // (15) * 2 - 2 = 30 - 2 = 28
        assertEquals(28.0, env.getVariable("resultado"), 0.001);
    }

    @Test
    public void test02_LgicaCondicional() throws Exception {
        String codigo = "x = 10 ;" +
                "if (x > 5) then { y = 1; } else { y = 0; } " +
                "if (x == 2) then { z = 1; } else { z = 0; } ";

        Environment env = executarPrograma(codigo);

        assertEquals("O IF deveria ter entrado no bloco THEN", 1.0, env.getVariable("y"), 0.001);
        assertEquals("O IF deveria ter entrado no bloco ELSE", 0.0, env.getVariable("z"), 0.001);
    }

    @Test
    public void test03_OGrandeFinal_Fatorial() throws Exception {
        // Um programa completo em JACA calculando o fatorial de 5 (5 * 4 * 3 * 2 * 1 =
        // 120)
        String codigo = "n = 5 ;" +
                "fatorial = 1 ;" +
                "while (n > 0) {" +
                "   fatorial = fatorial * n ;" +
                "   n = n - 1 ;" +
                "}";

        Environment env = executarPrograma(codigo);

        assertEquals("🎉 PARABÉNS! SEU COMPILADOR JACA ESTÁ VIVO! O fatorial falhou.", 120.0,
                env.getVariable("fatorial"), 0.001);
        assertEquals("O laço while não decrementou o 'n' corretamente.", 0.0, env.getVariable("n"), 0.001);
    }

    @Test
    public void test04_ErroSemantico_VariavelNaoDeclarada() {
        try {
            executarPrograma("x = y + 1;"); // y não existe!
            fail("O interpretador deveria lançar erro de variável não declarada.");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("não declarada"));
        }
    }
}