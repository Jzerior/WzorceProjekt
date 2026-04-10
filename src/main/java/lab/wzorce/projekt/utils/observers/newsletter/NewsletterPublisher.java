package lab.wzorce.projekt.utils.observers.newsletter;

// Tydzień 6, Wzorzec Observer 3
public interface NewsletterPublisher {
    void subscribe(NewsletterSubscriber subscriber);
    void unsubscribe(NewsletterSubscriber subscriber);
    void notifySubscribers();
}
// Koniec, Tydzień 6, Wzorzec Observer 3