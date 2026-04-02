package lab.wzorce.projekt.utils.mementos.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Tydzień 5, Wzorzec Memento 1
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class CartMemento {
    private final List<String> items;
    public CartMemento(List<String> items) { this.items = new ArrayList<>(items); }
    public List<String> getItems() { return items; }
}

// Koniec, Tydzień 5, Wzorzec Memento 1
