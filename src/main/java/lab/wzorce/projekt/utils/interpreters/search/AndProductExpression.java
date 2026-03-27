package lab.wzorce.projekt.utils.interpreters.search;

import lab.wzorce.projekt.models.Product;

// Tydzień 5, Wzorzec Interpreter 1
public class AndProductExpression implements ProductExpression {
    private final ProductExpression expr1;
    private final ProductExpression expr2;

    public AndProductExpression(ProductExpression expr1, ProductExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Product context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}