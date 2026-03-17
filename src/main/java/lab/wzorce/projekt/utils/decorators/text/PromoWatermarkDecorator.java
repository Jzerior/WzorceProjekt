package lab.wzorce.projekt.utils.decorators.text;

// Tydzień 3, Wzorzec Decorator 2
// Konkretny Dekorator 3 - dokleja na końcu opisu informację o trwającej promocji.
public class PromoWatermarkDecorator extends DescriptionDecorator {

    public PromoWatermarkDecorator(ProductDescription decoratedDescription) {
        super(decoratedDescription);
    }

    @Override
    public String getContent() {
        return super.getContent() + "\n*** KUP TERAZ - PROMOCJA -20% ***";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 2