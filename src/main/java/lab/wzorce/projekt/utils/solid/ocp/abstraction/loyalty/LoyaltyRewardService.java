package lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty;

import lab.wzorce.projekt.models.Order;
import java.util.ArrayList;
import java.util.List;

// Tydzień 7, Zasada OCP
// ZAMKNIĘTY na modyfikacje. Jeśli dział marketingu wymyśli nową promocję,
// nie zmieniamy ani jednej linijki w tej klasie. Po prostu wstrzykujemy nową regułę!
public class LoyaltyRewardService {
    private final List<LoyaltyPointRule> rules = new ArrayList<>();

    public void addRule(LoyaltyPointRule rule) {
        rules.add(rule);
    }

    public int calculateTotalPoints(Order order) {
        int totalPoints = 0;
        // Serwis po prostu przechodzi przez wszystkie wstrzyknięte abstrakcje (reguły)
        for (LoyaltyPointRule rule : rules) {
            totalPoints += rule.calculatePoints(order);
        }
        return totalPoints;
    }
}
// Koniec, Tydzień 7, Zasada OCP