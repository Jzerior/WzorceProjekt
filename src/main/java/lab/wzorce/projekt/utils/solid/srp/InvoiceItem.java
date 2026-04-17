package lab.wzorce.projekt.utils.solid.srp;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa ma tylko jedną odpowiedzialność: przechowuje dane o pojedynczej pozycji na fakturze.
public class InvoiceItem {
    private final String name;
    private final double price;
    private final int quantity;

    public InvoiceItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
// Koniec, Tydzień 7, Zasada SRP