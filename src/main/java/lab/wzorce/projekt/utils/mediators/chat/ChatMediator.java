package lab.wzorce.projekt.utils.mediators.chat;

/**
 * Tydzień 5, Wzorzec Mediator 1
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public interface ChatMediator {
    void sendMessage(String message, ChatUser user);
    void addUser(ChatUser user);
}

// Koniec, Tydzień 5, Wzorzec Mediator 1

