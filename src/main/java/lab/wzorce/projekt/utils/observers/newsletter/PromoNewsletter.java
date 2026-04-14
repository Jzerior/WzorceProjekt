package lab.wzorce.projekt.utils.observers.newsletter;

import java.util.ArrayList;
import java.util.List;

// Tydzień 6, Wzorzec Observer 3
public class PromoNewsletter implements NewsletterPublisher {
    private final List<NewsletterSubscriber> subscribers = new ArrayList<>();
    private String latestTitle;
    private String latestContent;

    public void publishIssue(String title, String content) {
        this.latestTitle = title;
        this.latestContent = content;
        System.out.println("\n[Dział Marketingu] Opublikowano nowy newsletter: " + title);
        notifySubscribers();
    }

    @Override
    public void subscribe(NewsletterSubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
            System.out.println("[Newsletter] Dodano nowego subskrybenta.");
        }
    }

    @Override
    public void unsubscribe(NewsletterSubscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("[Newsletter] Usunięto subskrybenta.");
    }

    @Override
    public void notifySubscribers() {
        for (NewsletterSubscriber subscriber : subscribers) {
            subscriber.update(latestTitle, latestContent);
        }
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 3