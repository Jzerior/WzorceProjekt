package lab.wzorce.projekt.utils.mediators.fulfillment;

/**
 * Tydzień 5, Wzorzec Mediator 3
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class LogisticsDept extends Department {
    public LogisticsDept(OrderMediator mediator) { super(mediator); }
    public void dispatch() { System.out.println("[Logistyka] Kurier odebrał paczkę."); }
}

// Koniec, Tydzień 5, Wzorzec Mediator 3
