package lab.wzorce.projekt.utils.states.order;

public class PaidState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("BŁĄD: Zamówienie zostało już wcześniej opłacone.");
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("Pakowanie i wysyłka zamówienia.");
        context.setState(new ShippedState()); // Zmiana stanu!
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Anulowano opłacone zamówienie. Zlecam zwrot środków (Refund).");
        context.setState(new CancelledState()); // Zmiana stanu!
    }

    @Override
    public String getStatusName() {
        return "OPŁACONE";
    }
}