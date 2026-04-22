package lab.wzorce.projekt.utils.solid.ocp.abstraction.discount;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Konkretna implementacja reguły (zamknięta w osobnej klasie).
public class VipDiscountRule implements DiscountRule {
    private double vipDiscountValue = 0.1;
    @Override
    public boolean isApplicable(double orderValue, boolean isVip) {
        return isVip;
    }

    @Override
    public double calculateDiscount(double orderValue) {
        return orderValue * vipDiscountValue;
    }
}
// Koniec, Tydzień 7, Zasada OCP