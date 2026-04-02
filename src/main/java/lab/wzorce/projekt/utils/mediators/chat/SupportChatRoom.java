package lab.wzorce.projekt.utils.mediators.chat;

/**
 * Tydzień 5, Wzorzec Mediator 1
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class SupportChatRoom implements ChatMediator {
    private java.util.List<ChatUser> users = new java.util.ArrayList<>();

    @Override
    public void addUser(ChatUser user) { users.add(user); }

    @Override
    public void sendMessage(String message, ChatUser sender) {
        for (ChatUser user : users) {
            if (user != sender) { user.receive(message); }
        }
    }
}

// Koniec, Tydzień 5, Wzorzec Mediator 1
