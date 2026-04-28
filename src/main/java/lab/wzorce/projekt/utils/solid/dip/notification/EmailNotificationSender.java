package lab.wzorce.projekt.utils.solid.dip.notification;

import org.springframework.stereotype.Service;

// Tydzień 8, Zasada DIP
//Konkretna implementacja klasy abstrakcyjnej, a co za tym idzie interfejsu
@Service
public class EmailNotificationSender extends BaseNotificationSender {
    public EmailNotificationSender() {
        super("system@sklep.pl");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Wysyłanie Emaila od [" + senderId + "]: " + message);
    }
}
// Koniec, Tydzień 8, Zasada DIP