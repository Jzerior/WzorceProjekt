package lab.wzorce.projekt.utils.observers.stock;

// Tydzień 6, Wzorzec Observer 1
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
// Koniec, Tydzień 6, Wzorzec Observer 1