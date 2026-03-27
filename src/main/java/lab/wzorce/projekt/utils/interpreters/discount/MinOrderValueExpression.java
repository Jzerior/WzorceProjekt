package lab.wzorce.projekt.utils.interpreters.discount;

import lab.wzorce.projekt.models.Order;
import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 3
public class MinOrderValueExpression implements DiscountExpression {
    private final BigDecimal minValue;

    public MinOrderValueExpression(double minValue) {
        this.minValue = BigDecimal.valueOf(minValue);
    }

    @Override
    public boolean interpret(Order context) {
        return context.getTotalPrice().compareTo(minValue) >= 0;
    }
}