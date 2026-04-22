package lab.wzorce.projekt.utils.solid.ocp.datadriven;

import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OCP (Sterowanie danymi)
// Ta klasa jest zamknięta na zmiany kodu.
// Nowe reguły zniżkowe dodajemy wstrzykując nowe dane do mapy.
public class DataDrivenDiscountPolicy {
    private final Map<String, Double> categoryDiscounts = new HashMap<>();

    public void addCategoryDiscount(String category, double discountPercentage) {
        categoryDiscounts.put(category.toLowerCase(), discountPercentage);
    }

    public double calculateDiscount(String category, double price) {
        Double discountRate = categoryDiscounts.get(category.toLowerCase());
        if (discountRate != null) {
            return price * discountRate;
        }
        return 0; //Brak zniżki
    }
}
// Koniec, Tydzień 7, Zasada OCP