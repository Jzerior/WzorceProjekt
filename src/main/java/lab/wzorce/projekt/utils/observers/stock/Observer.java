package lab.wzorce.projekt.utils.observers.stock;

// Tydzień 6, Wzorzec Observer 1
public interface Observer {
    void update(String productName, boolean inStock);
    String getLastNotification(); // Pomocnicze dla kontrolera REST
}
// Koniec, Tydzień 6, Wzorzec Observer 1