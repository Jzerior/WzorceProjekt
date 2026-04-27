package lab.wzorce.projekt.utils.solid.lsp.notification;

// Tydzień 8, Zasada LSP
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.
public class ShippedOrderNotification extends OrderNotification {
    private final String trackingUrl;

    public ShippedOrderNotification(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    @Override
    public String generateMessage(String orderId) {
        return super.generateMessage(orderId) + " Śledź paczkę tutaj: " + trackingUrl;
    }
}
// Koniec, Tydzień 8, Zasada LSP