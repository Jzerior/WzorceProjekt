package lab.wzorce.projekt.utils.mediators.fulfillment;

/**
 * Tydzień 5, Wzorzec Mediator 3
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class AccountingDept extends Department {
    public AccountingDept(OrderMediator mediator) { super(mediator); }
    public void issueInvoice() { System.out.println("[Księgowość] Wystawiono fakturę."); }
}

// Koniec, Tydzień 5, Wzorzec Mediator 3
