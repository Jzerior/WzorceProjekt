package lab.wzorce.projekt.utils.solid.srp.delivery;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa odpowiada WYŁĄCZNIE za logikę biznesową (obliczanie kosztów dostawy).
public class DeliveryCostCalculator {
    private static final double BASE_COST = 15.0;
    private static final double COST_PER_KG = 2.0;
    private static final double COST_PER_KM = 0.5;

    public double calculateTotalCost(Delivery delivery) {
        double weightCost = delivery.getWeightKg() * COST_PER_KG;
        double distanceCost = delivery.getDistanceKm() * COST_PER_KM;

        return BASE_COST + weightCost + distanceCost;
    }
}
// Koniec, Tydzień 7, Zasada SRP