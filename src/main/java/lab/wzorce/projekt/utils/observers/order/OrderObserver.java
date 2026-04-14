package lab.wzorce.projekt.utils.observers.order;

// Tydzień 6, Wzorzec Observer 2
public interface OrderObserver {
    void update(String orderId, String newStatus);
    String getLog(); // Metoda pomocnicza dla kontrolera REST
}
// Koniec, Tydzień 6, Wzorzec Observer 2