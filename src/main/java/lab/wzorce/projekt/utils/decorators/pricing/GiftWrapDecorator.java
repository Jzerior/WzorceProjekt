package lab.wzorce.projekt.utils.decorators.pricing;

// Tydzień 3, Wzorzec Decorator 1
// Konkretny Dekorator 1 - dodaje opłatę za ozdobne pakowanie oraz modyfikuje opis zamówienia.
public class GiftWrapDecorator extends OrderCostDecorator {

    public GiftWrapDecorator(OrderCost decoratedOrderCost) {
        super(decoratedOrderCost);
    }

    private static final double WRAPPING_FEE = 15.00;

    @Override
    public double getCost() {
        return super.getCost() + WRAPPING_FEE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Ozdobne pakowanie";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 1