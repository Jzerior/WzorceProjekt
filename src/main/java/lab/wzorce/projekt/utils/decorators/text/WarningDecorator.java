package lab.wzorce.projekt.utils.decorators.text;

// Tydzień 3, Wzorzec Decorator 2
// Konkretny Dekorator 2 - dokleja na początku tekstu ostrzeżenie dla klientów.
public class WarningDecorator extends DescriptionDecorator {

    public WarningDecorator(ProductDescription decoratedDescription) {
        super(decoratedDescription);
    }

    @Override
    public String getContent() {
        return "[UWAGA: Produkt tylko dla dorosłych!] " + super.getContent();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 2