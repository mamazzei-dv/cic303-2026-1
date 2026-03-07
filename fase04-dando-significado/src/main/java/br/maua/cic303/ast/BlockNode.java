package main.java.br.maua.cic303.ast;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends ASTNode {
    public final List<ASTNode> statements = new ArrayList<>();

    public void addStatement(ASTNode stmt) {
        if (stmt != null)
            statements.add(stmt);
    }

    @Override
    public String toString() {
        return "BLOCK" + statements.toString();
    }
}