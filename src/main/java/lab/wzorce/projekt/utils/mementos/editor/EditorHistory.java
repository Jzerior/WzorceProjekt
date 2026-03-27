package lab.wzorce.projekt.utils.mementos.editor;

import java.util.Stack;

/**
 * Tydzień 5, Wzorzec Memento 2
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class EditorHistory {
    private Stack<EditorMemento> history = new Stack<>();
    public void saveState(ProductEditor editor) { history.push(editor.save()); }
    public void undo(ProductEditor editor) {
        if (!history.isEmpty()) { editor.restore(history.pop()); }
    }
}

// Koniec, Tydzień 5, Wzorzec Memento 2
