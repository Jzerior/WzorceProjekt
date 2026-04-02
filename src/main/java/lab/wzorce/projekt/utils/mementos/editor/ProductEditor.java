package lab.wzorce.projekt.utils.mementos.editor;

/**
 * Tydzień 5, Wzorzec Memento 2
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class ProductEditor {
    private String content = "";
    public void type(String words) { content += words; }
    public String getContent() { return content; }

    public EditorMemento save() { return new EditorMemento(content); }
    public void restore(EditorMemento memento) { this.content = memento.getContent(); }
}

// Koniec, Tydzień 5, Wzorzec Memento 2
