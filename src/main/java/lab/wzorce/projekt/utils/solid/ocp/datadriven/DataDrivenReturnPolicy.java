package lab.wzorce.projekt.utils.solid.ocp.datadriven;

import lab.wzorce.projekt.models.Product;
import java.util.HashMap;
import java.util.Map;

// Tydzień 7, Zasada OCP (Poprzez sterowanie danymi)
// Klasa otwarta na rozszerzenia (możemy konfigurować nowe zasady dla nowych kategorii),
// ale zamknięta na modyfikacje (nie musimy zmieniać jej kodu, aby obsłużyć nową kategorię biznesową).
public class DataDrivenReturnPolicy {

    private final Map<String, Integer> returnRules = new HashMap<>();
    private final int defaultReturnDays;

    public DataDrivenReturnPolicy(int defaultReturnDays) {
        this.defaultReturnDays = defaultReturnDays;
    }

    public void addCategoryReturnRule(String category, int daysAllowed) {
        returnRules.put(category, daysAllowed);
    }

    public int calculateReturnDays(Product product) {
        if (product == null || product.getCategory() == null) {
            return defaultReturnDays;
        }
        return returnRules.getOrDefault(product.getCategory(), defaultReturnDays);
    }
}
// Koniec, Tydzień 7, Zasada OCP