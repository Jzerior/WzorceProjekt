package lab.wzorce.projekt.utils.observers.stock;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer 1
public class StockItem implements Subject {
    private final String productName;
    private boolean inStock;
    private final List<Observer> observers = new ArrayList<>();

    public StockItem(String productName, boolean inStock) {
        this.productName = productName;
        this.inStock = inStock;
    }

    public void setInStock(boolean inStock) {
        System.out.println("--- [System] Zmieniono stan dostępności produktu '" + productName + "' na: " + inStock + " ---");
        this.inStock = inStock;
        notifyObservers(); // Automatyczne powiadomienie po zmianie stanu
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(productName, inStock);
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 1