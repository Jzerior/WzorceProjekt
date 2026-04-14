package lab.wzorce.projekt.utils.observers.newsletter;

// Tydzień 6, Wzorzec Observer 3
public class RetailCustomer implements NewsletterSubscriber {
    private final String name;
    private String log = "";

    public RetailCustomer(String name) {
        this.name = name;
    }

    @Override
    public void update(String title, String content) {
        log = "[Klient Detaliczny: " + name + "] Otrzymano: " + title + " -> " + content;
        System.out.println(log);
    }

    @Override
    public String getLog() {
        return log;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 3