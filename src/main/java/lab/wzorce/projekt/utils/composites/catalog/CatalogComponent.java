package lab.wzorce.projekt.utils.composites.catalog;

/**
 * Tydzień 3, Wzorzec Composite 1,
 * Struktura Katalogu
 * Pozwala na traktowanie pojedynczych produktów oraz całych kategorii i podkategorii
 * w ten sam, jednolity sposób poprzez wspólny interfejs.
 * Dzięki temu klient może np. obliczyć wartość całej kategorii nie martwiąc się
 * o to, jak głęboko zagnieżdżone są w niej produkty.
 */

public interface CatalogComponent {
    String getName();
    double getPrice();
    void printDetails();
}

// Koniec, Tydzień 3, Wzorzec Composite 1