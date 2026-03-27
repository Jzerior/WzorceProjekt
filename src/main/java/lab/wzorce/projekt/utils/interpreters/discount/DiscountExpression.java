package lab.wzorce.projekt.utils.interpreters.discount;

import lab.wzorce.projekt.models.Order;

// Tydzień 5, Wzorzec Interpreter 3
public interface DiscountExpression {
    boolean interpret(Order context);
}