package lab.wzorce.projekt.utils.solid.ocp.abstraction.discount;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Konkretna implementacja reguły (zamknięta w osobnej klasie).
public class HighValueDiscountRule implements DiscountRule {
    private static final double MIN_ORDER_VALUE_FOR_DISCOUNT = 1000.0;
    private static final double DISCOUNT_AMOUNT = 50.00;

    @Override
    public boolean isApplicable(double orderValue, boolean isVip) {
        return orderValue > MIN_ORDER_VALUE_FOR_DISCOUNT;
    }

    @Override
    public double calculateDiscount(double orderValue) {
        return DISCOUNT_AMOUNT;
    }
}
// Koniec, Tydzień 7, Zasada OCP