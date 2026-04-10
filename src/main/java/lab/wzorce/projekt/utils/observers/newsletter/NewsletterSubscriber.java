package lab.wzorce.projekt.utils.observers.newsletter;

// Tydzień 6, Wzorzec Observer 3
public interface NewsletterSubscriber {
    void update(String title, String content);
    String getLog(); // Pomocnicze dla kontrolera
}
// Koniec, Tydzień 6, Wzorzec Observer 3