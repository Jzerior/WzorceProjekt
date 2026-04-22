package lab.wzorce.projekt.utils.solid.ocp.abstraction.ordervalidator;

import lab.wzorce.projekt.models.Order;
import java.util.ArrayList;
import java.util.List;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Klasa ZAMKNIĘTA na modyfikacje. Jeśli biznes wymyśli nową regułę walidacji
// (np. sprawdzanie poprawności adresu), nie zmieniamy kodu tej klasy.
// Jest ona otwarta na rozszerzenia, ponieważ wstrzykujemy do niej listę abstrakcji (OrderValidator).
public class OrderValidationService {
    private final List<OrderValidator> validators = new ArrayList<>();

    public void addValidator(OrderValidator validator) {
        validators.add(validator);
    }

    public List<String> validate(Order order) {
        List<String> errors = new ArrayList<>();
        for (OrderValidator validator : validators) {
            if (!validator.isValid(order)) {
                errors.add(validator.getValidationMessage());
            }
        }
        return errors;
    }
}
// Koniec, Tydzień 7, Zasada OCP