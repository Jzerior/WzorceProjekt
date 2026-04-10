package lab.wzorce.projekt.utils.observers.order;

// Tydzień 6, Wzorzec Observer 2
public class SmsOrderObserver implements OrderObserver {
    private final String phoneNumber;
    private String log = "";

    public SmsOrderObserver(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String orderId, String newStatus) {
        log = "[SMS na " + phoneNumber + "] Sklep: Zmiana statusu zam. " + orderId + " na " + newStatus;
        System.out.println(log);
    }

    @Override
    public String getLog() { return log; }
}
// Koniec, Tydzień 6, Wzorzec Observer 2