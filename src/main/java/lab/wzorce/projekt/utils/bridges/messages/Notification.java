// Tydzień 3, Wzorzec Bridge 1
package lab.wzorce.projekt.utils.bridges.messages;

public abstract class Notification {
    protected MessageSender messageSender; // Most (Bridge) do implementatora

    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract String send();
}
// Koniec tydzień 3, Wzorzec Bridge 1