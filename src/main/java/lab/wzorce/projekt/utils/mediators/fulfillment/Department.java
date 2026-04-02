package lab.wzorce.projekt.utils.mediators.fulfillment;

/**
 * Tydzień 5, Wzorzec Mediator 3
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public abstract class Department {
    protected OrderMediator mediator;
    public Department(OrderMediator mediator) { this.mediator = mediator; }
}

// Koniec, Tydzień 5, Wzorzec Mediator 3
