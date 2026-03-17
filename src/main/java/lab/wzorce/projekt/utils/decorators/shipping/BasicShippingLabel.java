package lab.wzorce.projekt.utils.decorators.shipping;

// Tydzień 3, Wzorzec Decorator 3
// Konkretny Komponent (Concrete Component).
// Reprezentuje podstawową etykietę, która zawiera tylko adres dostawy.
public class BasicShippingLabel implements ShippingLabel {
    private final String address;

    public BasicShippingLabel(String address) {
        this.address = address;
    }

    @Override
    public String printLabel() {
        return "=== ETYKIETA WYSYŁKOWA ===\nAdres: " + address;
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator 3