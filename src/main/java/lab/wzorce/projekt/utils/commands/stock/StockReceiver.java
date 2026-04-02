package lab.wzorce.projekt.utils.commands.stock;

// Tydzień 5, Wzorzec Command 1
public class StockReceiver {
    private final String productId;
    private int quantity;

    public StockReceiver(String productId, int initialQuantity) {
        this.productId = productId;
        this.quantity = initialQuantity;
    }

    public void addStock(int amount) {
        this.quantity += amount;
        System.out.println("Zwiększono stan magazynowy produktu " + productId + " o " + amount + ". Aktualny stan: " + quantity);
    }

    public void removeStock(int amount) {
        this.quantity -= amount;
        System.out.println("Zmniejszono stan magazynowy produktu " + productId + " o " + amount + ". Aktualny stan: " + quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}