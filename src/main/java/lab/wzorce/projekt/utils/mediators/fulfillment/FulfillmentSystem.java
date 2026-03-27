package lab.wzorce.projekt.utils.mediators.fulfillment;

/**
 * Tydzień 5, Wzorzec Mediator 3
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class FulfillmentSystem implements OrderMediator {
    private WarehouseDept warehouse;
    private AccountingDept accounting;
    private LogisticsDept logistics;

    public void setDepartments(WarehouseDept w, AccountingDept a, LogisticsDept l) {
        this.warehouse = w; this.accounting = a; this.logistics = l;
    }

    @Override
    public void notify(Department sender, String event) {
        if (sender == warehouse && event.equals("PACKAGED")) {
            accounting.issueInvoice();
            logistics.dispatch();
        }
    }
}

// Koniec, Tydzień 5, Wzorzec Mediator 3
