package lab.wzorce.projekt.utils.interpreters.search;

import lab.wzorce.projekt.models.Product;
import java.math.BigDecimal;

// Tydzień 5, Wzorzec Interpreter 1
public class CategoryExpression implements ProductExpression {
    private final String targetCategory;

    public CategoryExpression(String targetCategory) {
        this.targetCategory = targetCategory;
    }

    @Override
    public boolean interpret(Product context) {
        return context.getCategory().equalsIgnoreCase(targetCategory);
    }
}