package lab.wzorce.projekt.utils.solid.srp.invoice;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa odpowiada WYŁĄCZNIE za logikę biznesową (obliczenia finansowe).
// Jeśli zmieni się prawo podatkowe lub algorytm liczenia sumy, zmienimy TYLKO tę klasę.
public class InvoiceCalculator {
    private static final double VAT_RATE = 0.23;

    public double calculateTotalNet(Invoice invoice) {
        double total = 0;
        for (InvoiceItem item : invoice.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public double calculateTotalGross(Invoice invoice) {
        double net = calculateTotalNet(invoice);
        return net + (net * VAT_RATE);
    }

    public double calculateTaxAmount(Invoice invoice) {
        return calculateTotalNet(invoice) * VAT_RATE;
    }
}
// Koniec, Tydzień 7, Zasada SRP