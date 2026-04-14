package lab.wzorce.projekt.utils.states.order;

public class CancelledState implements OrderState {
    @Override
    public void pay(OrderContext context) {
        System.out.println("BŁĄD: Nie można opłacić anulowanego zamówienia.");
    }

    @Override
    public void ship(OrderContext context) {
        System.out.println("BŁĄD: Nie można wysłać anulowanego zamówienia.");
    }

    @Override
    public void cancel(OrderContext context) {
        System.out.println("BŁĄD: Zamówienie jest już anulowane.");
    }

    @Override
    public String getStatusName() {
        return "ANULOWANE";
    }
}