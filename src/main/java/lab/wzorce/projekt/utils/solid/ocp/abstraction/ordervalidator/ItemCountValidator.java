package lab.wzorce.projekt.utils.solid.ocp.abstraction.ordervalidator;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Kolejna konkretna implementacja reguły (zamknięta w osobnej klasie).
public class ItemCountValidator implements OrderValidator {
    private final int maxItems;

    public ItemCountValidator(int maxItems) {
        this.maxItems = maxItems;
    }

    @Override
    public boolean isValid(Order order) {
        int totalItems = order.getItems().stream().mapToInt(OrderItem::getQuantity).sum();
        return totalItems <= maxItems;
    }

    @Override
    public String getValidationMessage() {
        return "Zamówienie nie może przekraczać maksymalnej liczby przedmiotów wynoszącej: " + maxItems + " szt.";
    }
}
// Koniec, Tydzień 7, Zasada OCP