package lab.wzorce.projekt.utils.mediators.chat;

/**
 * Tydzień 5, Wzorzec Mediator 1
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class Customer extends ChatUser {
    public Customer(ChatMediator mediator, String name) { super(mediator, name); }
    @Override
    public void send(String message) { mediator.sendMessage(message, this); }
    @Override
    public void receive(String message) { System.out.println("Klient " + name + " odbiera: " + message); }
}

// Koniec, Tydzień 5, Wzorzec Mediator 1
