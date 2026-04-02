package lab.wzorce.projekt.utils.commands.order;

// Tydzień 5, Wzorzec Command 2
public class OrderReceiver {
    private String orderId;
    private String status;

    public OrderReceiver(String orderId) {
        this.orderId = orderId;
        this.status = "NEW";
    }

    public void pay() {
        this.status = "PAID";
        System.out.println("Zamówienie " + orderId + " zostało opłacone.");
    }

    public void ship() {
        this.status = "SHIPPED";
        System.out.println("Zamówienie " + orderId + " zostało wysłane.");
    }

    public void cancel() {
        this.status = "CANCELLED";
        System.out.println("Zamówienie " + orderId + " zostało anulowane.");
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}