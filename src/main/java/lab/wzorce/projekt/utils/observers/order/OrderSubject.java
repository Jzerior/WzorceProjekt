package lab.wzorce.projekt.utils.observers.order;

// Tydzień 6, Wzorzec Observer 2
public interface OrderSubject {
    void attach(OrderObserver observer);
    void detach(OrderObserver observer);
    void notifyObservers();
}
// Koniec, Tydzień 6, Wzorzec Observer 2