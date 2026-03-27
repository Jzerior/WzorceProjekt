package lab.wzorce.projekt.utils.mediators.fulfillment;

/**
 * Tydzień 5, Wzorzec Mediator 3
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class WarehouseDept extends Department {
    public WarehouseDept(OrderMediator mediator) { super(mediator); }
    public void packageItems() {
        System.out.println("[Magazyn] Towar spakowany.");
        mediator.notify(this, "PACKAGED");
    }
}

// Koniec, Tydzień 5, Wzorzec Mediator 3
