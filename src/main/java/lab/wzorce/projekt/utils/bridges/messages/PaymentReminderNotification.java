// Tydzień 3, Wzorzec Bridge 1
package lab.wzorce.projekt.utils.bridges.messages;

// Uszczegółowiona Abstrakcja B
public class PaymentReminderNotification extends Notification {
    private double amount;

    public PaymentReminderNotification(MessageSender messageSender, double amount) {
        super(messageSender);
        this.amount = amount;
    }

    @Override
    public String send() {
        String msg = "Przypominamy o oczekującej płatności na kwotę: " + amount + " PLN.";
        return messageSender.sendMessage(msg); // Delegacja do implementatora
    }
}
// Koniec tydzień 3, Wzorzec Bridge 1