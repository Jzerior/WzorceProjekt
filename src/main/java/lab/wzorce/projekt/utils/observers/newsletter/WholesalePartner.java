package lab.wzorce.projekt.utils.observers.newsletter;

// Tydzień 6, Wzorzec Observer 3
public class WholesalePartner implements NewsletterSubscriber {
    private final String companyName;
    private String log = "";

    public WholesalePartner(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void update(String title, String content) {
        log = "[Partner Hurtowy: " + companyName + "] Otrzymano: " + title + " -> " + content + " (Pamiętaj o swoim stałym rabacie -20% B2B!)";
        System.out.println(log);
    }

    @Override
    public String getLog() {
        return log;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 3