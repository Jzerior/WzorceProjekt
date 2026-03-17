package lab.wzorce.projekt.utils.decorators.text;

// Tydzień 3, Wzorzec Decorator 2
// Konkretny Komponent (Concrete Component).
// Reprezentuje zwykły, surowy tekst opisu produktu bez żadnych dodatków.
public class BasicDescription implements ProductDescription {
    private final String text;

    public BasicDescription(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return text;
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 2