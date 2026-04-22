package lab.wzorce.projekt.utils.solid.srp.invoice;

import java.util.ArrayList;
import java.util.List;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa modelu (Data Holder). Jej jedynym powodem do zmiany jest zmiana struktury danych faktury
// (np. dodanie numeru NIP klienta). Nie ma tu żadnej logiki obliczeniowej ani formatującej.
public class Invoice {
    private final String customerName;
    private final List<InvoiceItem> items;

    public Invoice(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(InvoiceItem item) {
        items.add(item);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }
}
// Koniec, Tydzień 7, Zasada SRP