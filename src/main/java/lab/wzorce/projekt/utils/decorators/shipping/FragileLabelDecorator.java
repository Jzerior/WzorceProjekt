package lab.wzorce.projekt.utils.decorators.shipping;

// Tydzień 3, Wzorzec Decorator 3
// Konkretny Dekorator 1 - dodaje na etykietę naklejkę ostrzegawczą "Ostrożnie szkło".
public class FragileLabelDecorator extends LabelDecorator {

    public FragileLabelDecorator(ShippingLabel decoratedLabel) {
        super(decoratedLabel);
    }

    @Override
    public String printLabel() {
        return super.printLabel() + "\n[NAKLEJKA]: OSTROŻNIE SZKŁO!";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 3