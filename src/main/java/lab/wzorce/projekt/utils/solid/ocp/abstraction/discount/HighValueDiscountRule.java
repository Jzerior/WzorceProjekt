package lab.wzorce.projekt.utils.solid.ocp.abstraction.discount;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Konkretna implementacja reguły (zamknięta w osobnej klasie).
public class HighValueDiscountRule implements DiscountRule {
    public double highValueDiscountValue = 50.00;

    @Override
    public boolean isApplicable(double orderValue, boolean isVip) {
        return orderValue > 1000.0;
    }

    @Override
    public double calculateDiscount(double orderValue) {
        return highValueDiscountValue;
    }
}
// Koniec, Tydzień 7, Zasada OCP