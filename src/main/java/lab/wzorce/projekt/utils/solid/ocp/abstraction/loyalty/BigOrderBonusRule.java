package lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty;

import lab.wzorce.projekt.models.Order;
import java.math.BigDecimal;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Konkretna implementacja reguły (zamknięta w osobnej klasie).
public class BigOrderBonusRule implements LoyaltyPointRule {
    private final BigDecimal threshold;
    private final int bonusPoints;

    public BigOrderBonusRule(double threshold, int bonusPoints) {
        this.threshold = BigDecimal.valueOf(threshold);
        this.bonusPoints = bonusPoints;
    }

    @Override
    public int calculatePoints(Order order) {
        if (order.getTotalPrice() != null && order.getTotalPrice().compareTo(threshold) >= 0) {
            return bonusPoints;
        }
        return 0;
    }
}
// Koniec, Tydzień 7, Zasada OCP