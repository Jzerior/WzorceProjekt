package lab.wzorce.projekt.utils.decorators.shipping;

// Tydzień 3, Wzorzec Decorator 3
// Konkretny Dekorator 2 - dodaje informację o kwocie ubezpieczenia paczki.
public class InsuranceLabelDecorator extends LabelDecorator {
    private final double amount;

    public InsuranceLabelDecorator(ShippingLabel decoratedLabel, double amount) {
        super(decoratedLabel);
        this.amount = amount;
    }

    @Override
    public String printLabel() {
        return super.printLabel() + "\n[NAKLEJKA]: PACZKA UBEZPIECZONA NA KWOTĘ " + amount + " PLN";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 3