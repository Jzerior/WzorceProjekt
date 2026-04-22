package lab.wzorce.projekt.utils.solid.ocp.abstraction.ordervalidator;

import lab.wzorce.projekt.models.Order;

// Tydzień 7, Zasada OCP (Poprzez abstrakcję)
// Interfejs definiujący kontrakt dla walidatorów zamówienia.
// Otwarty na rozszerzenia: możemy w przyszłości dodawać dowolną liczbę
// nowych walidatorów, tworząc nowe klasy implementujące ten interfejs.
public interface OrderValidator {
    boolean isValid(Order order);
    String getValidationMessage();
}
// Koniec, Tydzień 7, Zasada OCP