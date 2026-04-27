package lab.wzorce.projekt.utils.solid.dip.notification;

// Tydzień 8, Zasada DIP
//Bazowy interfejs, abstrakcja na której mogą polegać moduły wysokopoziomowe
public interface NotificationSender {
    void sendNotification(String message);
}
// Koniec, Tydzień 8, Zasada DIP