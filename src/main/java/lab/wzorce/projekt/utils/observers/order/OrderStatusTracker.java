package lab.wzorce.projekt.utils.observers.order;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer 2
public class OrderStatusTracker implements OrderSubject {
    private final String orderId;
    private String status;
    private final List<OrderObserver> observers = new ArrayList<>();

    public OrderStatusTracker(String orderId, String initialStatus) {
        this.orderId = orderId;
        this.status = initialStatus;
    }

    public void setStatus(String newStatus) {
        System.out.println("\n[System Zamówień] Zamówienie " + orderId + " zmieniło status na: " + newStatus);
        this.status = newStatus;
        notifyObservers(); // Kluczowy element wzorca - powiadomienie po modyfikacji stanu
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void attach(OrderObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(orderId, status);
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 2