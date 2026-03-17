package lab.wzorce.projekt.utils.decorators.pricing;

// Tydzień 3, Wzorzec Decorator 1
// Dekorator (Decorator) - abstrakcyjna klasa bazowa dla wszystkich dekoratorów kosztów.
// Posiada referencję do obiektu typu OrderCost (owija go) i deleguje do niego domyślne wywołania metod.
public abstract class OrderCostDecorator implements OrderCost {
    protected OrderCost decoratedOrderCost;

    public OrderCostDecorator(OrderCost decoratedOrderCost) {
        this.decoratedOrderCost = decoratedOrderCost;
    }

    @Override
    public double getCost() {
        return decoratedOrderCost.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedOrderCost.getDescription();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 1