package lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty;

import lab.wzorce.projekt.models.Order;

// Tydzień 7, Zasada OCP
// Interfejs definiujący kontrakt dla reguł naliczania punktów.
// OTWARTY na rozszerzenia: możemy w przyszłości dodawać nowe reguły promocyjne.
public interface LoyaltyPointRule {
    int calculatePoints(Order order);
}
// Koniec, Tydzień 7, Zasada OCP