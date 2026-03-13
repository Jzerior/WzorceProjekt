// Tydzień 3, Wzorzec Bridge 1
package lab.wzorce.projekt.utils.bridges.messages;

// Uszczegółowiona Abstrakcja A
public class OrderShippedNotification extends Notification {
    private String orderId;

    public OrderShippedNotification(MessageSender messageSender, String orderId) {
        super(messageSender);
        this.orderId = orderId;
    }

    @Override
    public String send() {
        String msg = "Twoje zamówienie o numerze " + orderId + " zostało wysłane.";
        return messageSender.sendMessage(msg); // Delegacja do implementatora
    }
}
// Koniec tydzień 3, Wzorzec Bridge 1