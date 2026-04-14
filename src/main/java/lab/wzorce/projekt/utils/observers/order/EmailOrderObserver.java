package lab.wzorce.projekt.utils.observers.order;

// Tydzień 6, Wzorzec Observer 2
public class EmailOrderObserver implements OrderObserver {
    private final String emailAddress;
    private String log = "";

    public EmailOrderObserver(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void update(String orderId, String newStatus) {
        log = "[EMAIL do " + emailAddress + "] Witaj! Twoje zamówienie " + orderId + " ma teraz status: " + newStatus;
        System.out.println(log);
    }

    @Override
    public String getLog() { return log; }
}
// Koniec, Tydzień 6, Wzorzec Observer 2