// Tydzień 3, Wzorzec Bridge 1
package lab.wzorce.projekt.utils.bridges.messages;

public class SmsSender implements MessageSender {
    @Override
    public String sendMessage(String message) {
        return "[SMS] Wysyłanie wiadomości: " + message;
    }
}
// Koniec tydzień 3, Wzorzec Bridge 1