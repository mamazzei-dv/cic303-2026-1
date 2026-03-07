# 🧩 Fase 4: Dando Significado (A Árvore AST)

A sintaxe da nossa linguagem JACA já está garantida (Fase 3). Mas validar não é o suficiente para um compilador: precisamos salvar essa estrutura na memória para que o computador possa calcular os resultados!

Para isso, usamos a **AST (Abstract Syntax Tree)**.

## 🎯 O Desafio
O professor forneceu um pacote completo de classes Java dentro da pasta `ast` (`BinOpNode`, `AssignNode`, `NumberNode`, etc.). 

O seu trabalho é abrir o arquivo `Parser.cup` e **injetar código Java dentro das regras gramaticais** usando os blocos `{: :}` para instanciar esses nós sempre que o parser reconhecer uma regra.

**Exemplo de Ação Semântica no CUP:**
```cup
expr ::= expr:e1 ADD_OP:op expr:e2 
         {: RESULT = new BinOpNode(op, e1, e2); :} ;


🛠️ Passos
Traga os arquivos Lexer.lex (Fase 2) para este projeto.

Complete o Parser.cup adicionando as ações {: RESULT = ... :}.

Não esqueça de capturar os atributos enviados pelo Léxico usando rótulos (ex: ID:nome_variavel).

🚦 Avaliação
Rode: mvn test


O teste tentará desenhar a sua Árvore AST em formato de texto (notação LISP) e comparar com a árvore estruturalmente perfeita que o professor definiu no gabarito!

