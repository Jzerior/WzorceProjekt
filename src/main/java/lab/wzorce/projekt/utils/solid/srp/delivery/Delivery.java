package lab.wzorce.projekt.utils.solid.srp.delivery;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa modelu (Data Holder). Przechowuje wyłącznie dane dostawy.
public class Delivery {
    private final String recipientName;
    private final String address;
    private final double weightKg;
    private final double distanceKm;

    public Delivery(String recipientName, String address, double weightKg, double distanceKm) {
        this.recipientName = recipientName;
        this.address = address;
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getAddress() {
        return address;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public double getDistanceKm() {
        return distanceKm;
    }
}
// Koniec, Tydzień 7, Zasada SRP