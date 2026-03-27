package lab.wzorce.projekt.utils.interpreters.discount;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;

// Tydzień 5, Wzorzec Interpreter 3
public class HasItemCategoryExpression implements DiscountExpression {
    private final String requiredCategory;

    public HasItemCategoryExpression(String requiredCategory) {
        this.requiredCategory = requiredCategory;
    }

    @Override
    public boolean interpret(Order context) {
        for (OrderItem item : context.getItems()) {
            if (item.getProduct().getCategory().equalsIgnoreCase(requiredCategory)) {
                return true;
            }
        }
        return false;
    }
}