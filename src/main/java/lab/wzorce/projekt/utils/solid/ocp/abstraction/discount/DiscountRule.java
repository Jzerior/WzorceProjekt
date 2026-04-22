package lab.wzorce.projekt.utils.solid.ocp.abstraction.discount;

// Tydzień 7, Zasada OCP
// Interfejs definiujący kontrakt dla reguł naliczania punktów.
// OTWARTY na rozszerzenia: możemy w przyszłości dodawać nowe reguły zniżkowe.
public interface DiscountRule {
    boolean isApplicable(double orderValue, boolean isVip);
    double calculateDiscount(double orderValue);
}
// Koniec, Tydzień 7, Zasada OCP