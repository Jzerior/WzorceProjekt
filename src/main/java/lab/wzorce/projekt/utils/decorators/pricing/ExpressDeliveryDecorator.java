package lab.wzorce.projekt.utils.decorators.pricing;

// Tydzień 3, Wzorzec Decorator 1
// Konkretny Dekorator 2 - dodaje opłatę za szybką wysyłkę oraz odpowiednio modyfikuje opis zamówienia.
public class ExpressDeliveryDecorator extends OrderCostDecorator {

    public ExpressDeliveryDecorator(OrderCost decoratedOrderCost) {
        super(decoratedOrderCost);
    }

    @Override
    public double getCost() {
        return super.getCost() + 25.00;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Dostawa ekspresowa";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 1