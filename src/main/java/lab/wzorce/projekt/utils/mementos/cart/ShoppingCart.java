package lab.wzorce.projekt.utils.mementos.cart;

import java.util.ArrayList;
import java.util.List;

/**
 * Tydzień 5, Wzorzec Memento 1
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class ShoppingCart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) { items.add(item); }
    public void removeItem(String item) { items.remove(item); }
    public void printCart() { System.out.println("Koszyk: " + items); }

    public CartMemento save() { return new CartMemento(items); }
    public void restore(CartMemento memento) { this.items = new ArrayList<>(memento.getItems()); }
}

// Koniec, Tydzień 5, Wzorzec Memento 1
