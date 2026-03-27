package lab.wzorce.projekt.utils.interpreters.search;

import lab.wzorce.projekt.models.Product;
import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 1
public class MaxPriceExpression implements ProductExpression {
    private final BigDecimal maxPrice;

    public MaxPriceExpression(double maxPrice) {
        this.maxPrice = BigDecimal.valueOf(maxPrice);
    }

    @Override
    public boolean interpret(Product context) {
        return context.getPrice().compareTo(maxPrice) <= 0;
    }
}