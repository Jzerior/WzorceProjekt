package lab.wzorce.projekt.utils.decorators.text;

// Tydzień 3, Wzorzec Decorator 2
// Dekorator (Decorator) - abstrakcyjna klasa bazowa dla wszystkich modyfikatorów tekstu.
// Posiada referencję do obiektu typu ProductDescription i deleguje do niego pobranie treści.
public abstract class DescriptionDecorator implements ProductDescription {
    protected ProductDescription decoratedDescription;

    public DescriptionDecorator(ProductDescription decoratedDescription) {
        this.decoratedDescription = decoratedDescription;
    }

    @Override
    public String getContent() {
        return decoratedDescription.getContent();
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 2