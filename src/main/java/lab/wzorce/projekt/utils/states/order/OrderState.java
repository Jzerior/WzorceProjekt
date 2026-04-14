package lab.wzorce.projekt.utils.states.order;

/**
 * Tydzień 7, Wzorzec State 1
 * Interfejs wspólny dla wszystkich stanów zamówienia.
 * Każdy stan musi zdefiniować, jak zachowa się zamówienie przy próbie
 * opłacenia, wysyłki lub anulowania.
 */
public interface OrderState {
    void pay(OrderContext context);
    void ship(OrderContext context);
    void cancel(OrderContext context);
    String getStatusName();
}