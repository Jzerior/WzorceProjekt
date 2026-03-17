package lab.wzorce.projekt.utils.decorators.shipping;

// Tydzień 3, Wzorzec Decorator 3
// Dekorator (Decorator) - abstrakcyjna klasa bazowa dla dodatkowych naklejek/informacji na etykiecie.
public abstract class LabelDecorator implements ShippingLabel {
    protected ShippingLabel decoratedLabel;

    public LabelDecorator(ShippingLabel decoratedLabel) {
        this.decoratedLabel = decoratedLabel;
    }

    @Override
    public String printLabel() {
        return decoratedLabel.printLabel();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 3