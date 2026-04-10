package lab.wzorce.projekt.utils.strategies.sorting;

import lab.wzorce.projekt.models.Product;
import java.util.Comparator;
import java.util.List;

/**
 * Tydzień 6, Wzorzec Strategy 3
 * Wzorzec ten pozwala na zdefiniowanie rodziny algorytmów,
 * zamknięcie każdego z nich w osobnej klasie i sprawienie,
 * by były one ze sobą wymienne w zależności od potrzeb.
 * Dzięki temu możesz elastycznie zmieniać zachowanie obiektu w trakcie
 * działania programu bez ingerencji w jego pierwotny kod.
 */

public class NameAscendingStrategy implements SortingStrategy {
    @Override
    public void sort(List<Product> products) {
        products.sort(Comparator.comparing(Product::getName));
    }
}

// Koniec, Tydzień 6, Wzorzec Strategy 3