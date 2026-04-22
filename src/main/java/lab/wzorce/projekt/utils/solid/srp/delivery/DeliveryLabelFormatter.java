package lab.wzorce.projekt.utils.solid.srp.delivery;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa odpowiada WYŁĄCZNIE za logikę prezentacji (generowanie widoku etykiety).
public class DeliveryLabelFormatter {
    private final DeliveryCostCalculator calculator;

    public DeliveryLabelFormatter(DeliveryCostCalculator calculator) {
        this.calculator = calculator;
    }

    public String formatLabel(Delivery delivery) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ETYKIETA KURIERSKA ===\n");
        sb.append("Odbiorca: ").append(delivery.getRecipientName()).append("\n");
        sb.append("Adres docelowy: ").append(delivery.getAddress()).append("\n");
        sb.append("Waga paczki: ").append(delivery.getWeightKg()).append(" kg\n");
        sb.append("Kwota do pobrania: ").append(calculator.calculateTotalCost(delivery)).append(" PLN\n");
        sb.append("==========================\n");

        return sb.toString();
    }
}
// Koniec, Tydzień 7, Zasada SRP