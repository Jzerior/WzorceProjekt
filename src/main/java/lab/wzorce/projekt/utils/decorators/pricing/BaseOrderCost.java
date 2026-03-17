package lab.wzorce.projekt.utils.decorators.pricing;

// Tydzień 3, Wzorzec Decorator 1
// Konkretny Komponent (Concrete Component).
// Reprezentuje podstawowe zamówienie bez żadnych dodatkowych, płatnych usług.
public class BaseOrderCost implements OrderCost {
    private final double basePrice;

    public BaseOrderCost(double basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public double getCost() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Podstawowe zamówienie";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 1