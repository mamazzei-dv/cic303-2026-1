package br.maua.cic303;

public class LexerManual {
    private String entrada;
    private int posicao;

    public LexerManual(String entrada) {
        this.entrada = entrada;
        this.posicao = 0;
    }

    /**
     * Tenta ler o próximo Token da entrada.
     * Retorna um Token com a Tag.EOF quando a entrada terminar.
     */
    public Token nextToken() {
        // TODO: Seu código entra aqui!

        // 1. Pular espaços em branco (\s, \t, \n)

        // 2. Verificar se chegou no final da string (Retornar Tag.EOF)

        // 3. Identificar Operadores (=, +, -, *, /)

        // 4. Identificar Números (Dica: use expressões regulares ou Character.isDigit)

        // 5. Identificar Identificadores (Nomes de variáveis)

        // Se chegou até aqui e não reconheceu nada, retorne um erro temporário:
        if (posicao >= entrada.length()) {
            return new Token(Tag.EOF, "");
        }

        // Avança 1 caractere forçadamente para não travar num loop infinito caso você erre.
        String lexemaNaoReconhecido = String.valueOf(entrada.charAt(posicao));
        posicao++;

        return new Token(Tag.ERROR, lexemaNaoReconhecido);
    }
}