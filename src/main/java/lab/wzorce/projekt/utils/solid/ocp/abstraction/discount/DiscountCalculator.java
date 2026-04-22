package lab.wzorce.projekt.utils.solid.ocp.abstraction.discount;

import java.util.List;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Klasa zależna od abstrakcji a nie od konkretnych implemetnacji. Nawet w przypadku dodania nowych typów zniżek, modyfikacje nie są wymagane.
public class DiscountCalculator {
    private final List<DiscountRule> rules;

    public DiscountCalculator(List<DiscountRule> rules) {
        this.rules = rules;
    }

    public double calculateBestDiscount(double orderValue, boolean isVip) {
        double maxDiscount = 0;
        for (DiscountRule rule : rules) {
            if (rule.isApplicable(orderValue, isVip)) {
                double discount = rule.calculateDiscount(orderValue);
                if (discount > maxDiscount) {
                    maxDiscount = discount;
                }
            }
        }
        return maxDiscount;
    }
}
// Koniec, Tydzień 7, Zasada OCP