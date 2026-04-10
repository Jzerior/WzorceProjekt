package lab.wzorce.projekt.utils.observers.stock;

// Tydzień 6, Wzorzec Observer 1
public class CustomerSubscriber implements Observer {
    private final String customerName;
    private String lastNotification = "";

    public CustomerSubscriber(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productName, boolean inStock) {
        // Klient chce wiedzieć tylko wtedy, gdy towar staje się dostępny
        if (inStock) {
            lastNotification = "[Email do: " + customerName + "] Twój obserwowany produkt '" + productName + "' jest znów dostępny!";
            System.out.println(lastNotification);
        }
    }

    @Override
    public String getLastNotification() {
        return lastNotification;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer 1