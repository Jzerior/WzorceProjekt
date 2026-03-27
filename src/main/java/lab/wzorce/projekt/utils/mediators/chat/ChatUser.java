package lab.wzorce.projekt.utils.mediators.chat;

/**
 * Tydzień 5, Wzorzec Mediator 1
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public abstract class ChatUser {
    protected ChatMediator mediator;
    protected String name;

    public ChatUser(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }
    public abstract void send(String message);
    public abstract void receive(String message);
}

// Koniec, Tydzień 5, Wzorzec Mediator 1

