package br.maua.cic303;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ValidadorFase1Test {

    private List<Token> extrairTokens(String codigo) {
        LexerManual lexer = new LexerManual(codigo);
        List<Token> tokens = new ArrayList<>();
        Token t;
        while ((t = lexer.nextToken()).tag != Tag.EOF) {
            tokens.add(t);
            // Trava de segurança para evitar loops infinitos se o aluno não incrementar a
            // posição
            if (tokens.size() > 100)
                fail("Loop infinito detectado no LexerManual.");
        }
        return tokens;
    }

    @Test
    public void test01_IgnorarEspacosEmBranco() {
        List<Token> tokens = extrairTokens("   \t \n  ");
        assertEquals("O lexer deveria ignorar todos os espaços e retornar apenas EOF (lista vazia).", 0, tokens.size());
    }

    @Test
    public void test02_OperadoresSimples() {
        List<Token> tokens = extrairTokens("= + * / -");
        assertEquals("Deveria ter encontrado 5 operadores.", 5, tokens.size());
        assertEquals(Tag.ASSIGN, tokens.get(0).tag);
        assertEquals(Tag.ADD_OP, tokens.get(1).tag);
        assertEquals(Tag.MUL_OP, tokens.get(2).tag);
        assertEquals(Tag.MUL_OP, tokens.get(3).tag);
        assertEquals(Tag.ADD_OP, tokens.get(4).tag);
    }

    @Test
    public void test03_Identificadores() {
        List<Token> tokens = extrairTokens("x soma_total valor1");
        assertEquals(3, tokens.size());
        assertEquals("x", tokens.get(0).lexeme);
        assertEquals(Tag.ID, tokens.get(1).tag);
        assertEquals("soma_total", tokens.get(1).lexeme);
        assertEquals(Tag.ID, tokens.get(2).tag);
    }

    @Test
    public void test04_Numeros() {
        List<Token> tokens = extrairTokens("10 3.14");
        assertEquals(2, tokens.size());
        assertEquals(Tag.NUMBER, tokens.get(0).tag);
        assertEquals("10", tokens.get(0).lexeme);
        assertEquals(Tag.NUMBER, tokens.get(1).tag);
        assertEquals("3.14", tokens.get(1).lexeme);
    }

    @Test
    public void test05_ProgramaCompleto() {
        // Testa se o Lexer consegue separar as coisas quando elas estão misturadas
        List<Token> tokens = extrairTokens("taxa = 15.5 + temp_1;");

        // Esperado: ID, ASSIGN, NUMBER, ADD_OP, ID, ERROR (pois o ';' ainda não foi
        // mapeado nesta fase)
        assertEquals(6, tokens.size());
        assertEquals(Tag.ID, tokens.get(0).tag);
        assertEquals(Tag.ASSIGN, tokens.get(1).tag);
        assertEquals(Tag.NUMBER, tokens.get(2).tag);
        assertEquals(Tag.ADD_OP, tokens.get(3).tag);
        assertEquals(Tag.ID, tokens.get(4).tag);
        assertEquals(Tag.ERROR, tokens.get(5).tag); // O ponto e vírgula propositalmente deve dar erro nesta fase.
    }
}