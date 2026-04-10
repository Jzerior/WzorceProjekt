package lab.wzorce.projekt.utils.observers.stock;

// Tydzień 6, Wzorzec Observer 1
public class StoreManagerSubscriber implements Observer {
    private final String managerName;
    private String lastNotification = "";

    public StoreManagerSubscriber(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public void update(String productName, boolean inStock) {
        // Manager chce wiedzieć o każdej zmianie
        String status = inStock ? "DOSTĘPNY" : "BRAK NA MAGAZYNIE";
        lastNotification = "[Panel Managera: " + managerName + "] Zmiana statusu produktu '" + productName + "' na: " + status;
        System.out.println(lastNotification);
    }

    @Override
    public String getLastNotification() {
        return lastNotification;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 1