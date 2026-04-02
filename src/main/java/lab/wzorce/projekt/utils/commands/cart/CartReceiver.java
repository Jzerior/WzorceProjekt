package lab.wzorce.projekt.utils.commands.cart;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Command 3
public class CartReceiver {
    private final List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
        System.out.println("Dodano do koszyka: " + item);
    }

    public void removeItem(String item) {
        items.remove(item);
        System.out.println("Usunięto z koszyka: " + item);
    }

    public List<String> getItems() {
        return items;
    }
}