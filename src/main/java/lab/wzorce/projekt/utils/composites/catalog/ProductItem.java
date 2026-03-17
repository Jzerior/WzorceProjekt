package lab.wzorce.projekt.utils.composites.catalog;

/**
 * Tydzień 3, Wzorzec Composite 1,
 * Struktura Katalogu
 * Pozwala na traktowanie pojedynczych produktów oraz całych kategorii i podkategorii
 * w ten sam, jednolity sposób poprzez wspólny interfejs.
 * Dzięki temu klient może np. obliczyć wartość całej kategorii nie martwiąc się
 * o to, jak głęboko zagnieżdżone są w niej produkty.
 */

public class ProductItem implements CatalogComponent {
    private String name;
    private double price;

    public ProductItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() { return price; }

    @Override
    public void printDetails() {
        System.out.println(" - Produkt: " + name + " (Cena: " + price + " PLN)");
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 1