package lab.wzorce.projekt.utils.interpreters.discount;

import lab.wzorce.projekt.models.Order;

// Tydzień 5, Wzorzec Interpreter 3
public class AndDiscountExpression implements DiscountExpression {
    private final DiscountExpression expr1;
    private final DiscountExpression expr2;

    public AndDiscountExpression(DiscountExpression expr1, DiscountExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Order context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}