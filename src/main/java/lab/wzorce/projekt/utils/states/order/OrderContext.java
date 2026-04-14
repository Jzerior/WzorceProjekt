package lab.wzorce.projekt.utils.states.order;

/**
 * Tydzień 7, Wzorzec State 1
 * Kontekst przechowujący aktualny stan. Metody (akcje) wywoływane na kontekście
 * są po prostu delegowane do aktualnego obiektu stanu.
 */
public class OrderContext {
    private OrderState state;
    private final String orderId;

    public OrderContext(String orderId) {
        this.orderId = orderId;
        // Domyślnie nowe zamówienie zawsze otrzymuje status "Nowe"
        this.state = new NewState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void pay() {
        state.pay(this);
    }

    public void ship() {
        state.ship(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public String getStatus() {
        return state.getStatusName();
    }

    public String getOrderId() {
        return orderId;
    }
}