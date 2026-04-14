package lab.wzorce.projekt.utils.states.order;

public class NewState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("Zamówienie opłacone pomyślnie.");
        context.setState(new PaidState()); // Zmiana stanu!
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("BŁĄD: Nie można wysłać nieopłaconego zamówienia.");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("Anulowano nowe zamówienie.");
        context.setState(new CancelledState()); // Zmiana stanu!
    }

    @Override
    public String getStatusName() {
        return "NOWE";
    }
}