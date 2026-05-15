package lab.wzorce.projekt.utils.solid.ocp.abstraction.ordervalidator;

import lab.wzorce.projekt.models.Order;
import java.math.BigDecimal;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Konkretna implementacja reguły biznesowej.
public class MinOrderValueValidator implements OrderValidator {
    private final BigDecimal minValue;

    public MinOrderValueValidator(double minValue) {
        // Tydzień 9, Clean Code -exception example
        if (minValue < 0) {
            throw new IllegalArgumentException("Minimalna wartość zamówienia nie może być ujemna! Przekazano: " + minValue);
        }
        // Koniec, Tydzień 9, Clean Code -exception example

        this.minValue = BigDecimal.valueOf(minValue);
    }

    @Override
    public boolean isValid(Order order) {
        return order.getTotalPrice().compareTo(minValue) >= 0;
    }

    @Override
    public String getValidationMessage() {
        return "Zamówienie musi mieć wartość minimalną: " + minValue + " PLN";
    }
}
// Koniec, Tydzień 7, Zasada OCP