package lab.wzorce.projekt.utils.strategies.discount;

/**
 * Tydzień 6, Wzorzec Strategy 1
 * Wzorzec ten pozwala na zdefiniowanie rodziny algorytmów,
 * zamknięcie każdego z nich w osobnej klasie i sprawienie,
 * by były one ze sobą wymienne w zależności od potrzeb.
 * Dzięki temu możesz elastycznie zmieniać zachowanie obiektu w trakcie
 * działania programu bez ingerencji w jego pierwotny kod.
 */

public interface DiscountStrategy {
    double applyDiscount(double originalPrice);
}

// Koniec, Tydzień 6, Wzorzec Strategy 1