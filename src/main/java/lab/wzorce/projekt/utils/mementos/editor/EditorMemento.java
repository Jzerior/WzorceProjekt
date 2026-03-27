package lab.wzorce.projekt.utils.mementos.editor;

/**
 * Tydzień 5, Wzorzec Memento 2
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class EditorMemento {
    private final String content;
    public EditorMemento(String content) { this.content = content; }
    public String getContent() { return content; }
}

// Koniec, Tydzień 5, Wzorzec Memento 2
