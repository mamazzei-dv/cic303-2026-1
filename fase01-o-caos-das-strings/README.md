# 🚀 Fase 1: O Caos das Strings (Análise Léxica Manual)

Bem-vindo ao desenvolvimento do compilador da linguagem **JACA** (*Just Another Compiler Attempt*). 

O computador não entende o seu código como um texto completo. Para ele, o código é apenas uma "sopa de letrinhas" (caracteres). A primeira etapa de qualquer compilador é agrupar esses caracteres em palavras com significado, que chamamos de **Tokens**. Esse processo é a **Análise Léxica**.

## 🎯 O Desafio
Seu objetivo hoje é criar um Analisador Léxico (Scanner) "no braço", usando apenas código Java puro e a biblioteca nativa de Expressões Regulares (`java.util.regex.*`).

Para esta primeira fase, nosso compilador precisa reconhecer apenas um subconjunto da linguagem JACA:
1. **Identificadores (ID):** Começam com letra, seguidos de letras, números ou `_`.
2. **Números (NUMBER):** Sequências numéricas (ex: `123`, `3.14`).
3. **Atribuição (ASSIGN):** O símbolo `=`.
4. **Operadores Matemáticos (ADD_OP, MUL_OP):** Símbolos `+`, `-`, `*`, `/`.
5. **Espaços em branco:** Devem ser ignorados!

## 🛠️ O que você deve fazer?
Abra o arquivo `src/main/java/br/maua/cic303/LexerManual.java` e implemente a lógica dentro do método `nextToken()`. 

Você pode usar `String.split()`, percorrer a string com `.charAt()`, ou usar `Pattern` e `Matcher`. O importante é extrair o próximo Token válido!

## 🚦 Como saber se acertei? (Juiz Automático)
O projeto já possui testes automatizados. Abra o terminal na pasta raiz deste projeto e digite:
```bash
mvn test
```

## Chegagem alternativa

Se você fizer um fork do repositório, pode colocar sua resposta no arquivo LexerManual.java e, quando fizer o push para seu repositório com uma resposta correta, o check ficará verde. Enquanto estiver incompleto ou com erro, a marca permanecerá vermelha:

<img width="1700" height="104" alt="image" src="https://github.com/user-attachments/assets/445d555b-38c5-478f-a42b-c799cba2d937" />
