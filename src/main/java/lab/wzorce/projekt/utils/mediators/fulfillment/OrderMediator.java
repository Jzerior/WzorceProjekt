package lab.wzorce.projekt.utils.mediators.fulfillment;

/**
 * Tydzień 5, Wzorzec Mediator 3
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public interface OrderMediator {
    void notify(Department sender, String event);
}

// Koniec, Tydzień 5, Wzorzec Mediator 3
