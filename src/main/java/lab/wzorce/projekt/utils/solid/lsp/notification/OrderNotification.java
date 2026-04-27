package lab.wzorce.projekt.utils.solid.lsp.notification;

// Tydzień 8, Zasada LSP
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.
public class OrderNotification {
    public String generateMessage(String orderId) {
        return "Twoje zamówienie [" + orderId + "] zostało przetworzone pomyślnie.";
    }
}
// Koniec, Tydzień 8, Zasada LSP