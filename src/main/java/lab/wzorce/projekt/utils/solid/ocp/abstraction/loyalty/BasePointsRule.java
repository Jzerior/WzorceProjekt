package lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty;

import lab.wzorce.projekt.models.Order;
import java.math.BigDecimal;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Konkretna implementacja reguły (zamknięta w osobnej klasie).
public class BasePointsRule implements LoyaltyPointRule {
    @Override
    public int calculatePoints(Order order) {
        // 1 punkt za każde pełne wydane 10 PLN
        BigDecimal total = order.getTotalPrice();
        if (total == null) return 0;

        return total.divideToIntegralValue(new BigDecimal("10")).intValue();
    }
}
// Koniec, Tydzień 7, Zasada OCP