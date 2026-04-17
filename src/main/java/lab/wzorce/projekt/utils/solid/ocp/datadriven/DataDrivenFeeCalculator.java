package lab.wzorce.projekt.utils.solid.ocp.datadriven;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;
import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OCP (Sterowanie danymi)
// Klasa ZAMKNIĘTA na modyfikacje kodu algorytmu. Brak tu instrukcji warunkowych (if/switch)
// dla konkretnych kategorii produktów.
// Otwarta na rozszerzenia poprzez wstrzykiwanie danych konfiguracyjnych
// (nowe pary kategoria -> opłata) do mapy categoryFees w czasie działania programu.
public class DataDrivenFeeCalculator {
    private final Map<String, Double> categoryFees = new HashMap<>();

    // Metoda wstrzykująca nowe reguły w formie danych
    public void addCategoryFeeRule(String category, double fee) {
        categoryFees.put(category.toUpperCase(), fee);
    }

    public double calculateTotalHandlingFee(Order order) {
        double totalFee = 0.0;
        for (OrderItem item : order.getItems()) {
            String category = item.getProduct().getCategory().toUpperCase();

            // Logika oparta na danych strukturalnych, a nie hardkodowanym kodzie
            if (categoryFees.containsKey(category)) {
                totalFee += categoryFees.get(category) * item.getQuantity();
            }
        }
        return totalFee;
    }
}
// Koniec, Tydzień 7, Zasada OCP