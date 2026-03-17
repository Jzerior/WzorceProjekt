package lab.wzorce.projekt.utils.decorators.text;

// Tydzień 3, Wzorzec Decorator 2
// Konkretny Dekorator 1 - owija pobrany tekst w znaczniki pogrubienia HTML.
public class HtmlBoldDecorator extends DescriptionDecorator {

    public HtmlBoldDecorator(ProductDescription decoratedDescription) {
        super(decoratedDescription);
    }

    @Override
    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 2