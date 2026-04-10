package lab.wzorce.projekt.utils.strategies.shipping;

/**
 * Tydzień 6, Wzorzec Strategy 2
 * Wzorzec ten pozwala na zdefiniowanie rodziny algorytmów,
 * zamknięcie każdego z nich w osobnej klasie i sprawienie,
 * by były one ze sobą wymienne w zależności od potrzeb.
 * Dzięki temu możesz elastycznie zmieniać zachowanie obiektu w trakcie
 * działania programu bez ingerencji w jego pierwotny kod.
 */

public class ParcelLockerShippingStrategy implements ShippingStrategy {
    @Override
    public double calculate(double weightInKg) {
        return weightInKg > 25.0 ? 25.0 : 12.99;
    }
}

// Koniec, Tydzień 6, Wzorzec Strategy 2