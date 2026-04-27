package lab.wzorce.projekt.utils.solid.dip.notification;

// Tydzień 8, Zasada DIP
//Klasa abstrakcyjna, implementująca bazową logikę
public abstract class BaseNotificationSender implements NotificationSender {
    protected String senderId;

    public BaseNotificationSender(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public abstract void sendNotification(String message);
}
// Koniec, Tydzień 8, Zasada DIP