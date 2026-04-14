package lab.wzorce.projekt.utils.observers.order;

// Tydzień 6, Wzorzec Observer 2
public class PushOrderObserver implements OrderObserver {
    private final String deviceId;
    private String log = "";

    public PushOrderObserver(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void update(String orderId, String newStatus) {
        log = "[APP PUSH -> Urządzenie " + deviceId + "] 🔔 " + orderId + " to teraz: " + newStatus;
        System.out.println(log);
    }

    @Override
    public String getLog() { return log; }
}
// Koniec, Tydzień 6, Wzorzec Observer 2