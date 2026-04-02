package lab.wzorce.projekt.utils.mementos.cart;

import java.util.Stack;

/**
 * Tydzień 5, Wzorzec Memento 1
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class CartCaretaker {
    private Stack<CartMemento> history = new Stack<>();
    public void backup(ShoppingCart cart) { history.push(cart.save()); }
    public void undo(ShoppingCart cart) {
        if (!history.isEmpty()) { cart.restore(history.pop()); }
    }
}

// Koniec, Tydzień 5, Wzorzec Memento 1
