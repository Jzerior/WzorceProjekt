package lab.wzorce.projekt.utils.states.order;

public class ShippedState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("BŁĄD: Zamówienie jest już opłacone i wysłane.");
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("BŁĄD: Zamówienie zostało już wysłane.");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("BŁĄD: Nie można anulować zamówienia, które jest już w drodze do klienta.");
    }

    @Override
    public String getStatusName() {
        return "WYSŁANE";
    }
}