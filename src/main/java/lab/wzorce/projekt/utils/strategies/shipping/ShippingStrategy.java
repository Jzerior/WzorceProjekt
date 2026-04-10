package lab.wzorce.projekt.utils.strategies.shipping;

/**
 * Tydzień 6, Wzorzec Strategy 2
 * Wzorzec ten pozwala na zdefiniowanie rodziny algorytmów,
 * zamknięcie każdego z nich w osobnej klasie i sprawienie,
 * by były one ze sobą wymienne w zależności od potrzeb.
 * Dzięki temu możesz elastycznie zmieniać zachowanie obiektu w trakcie
 * działania programu bez ingerencji w jego pierwotny kod.
 */

public interface ShippingStrategy {
    double calculate(double weightInKg);
}

// Koniec, Tydzień 6, Wzorzec Strategy 2