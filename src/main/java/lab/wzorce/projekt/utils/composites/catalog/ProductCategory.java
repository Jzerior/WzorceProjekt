package lab.wzorce.projekt.utils.composites.catalog;

import java.util.ArrayList;
import java.util.List;

/**
 * Tydzień 3, Wzorzec Composite 1,
 * Struktura Katalogu
 * Pozwala na traktowanie pojedynczych produktów oraz całych kategorii i podkategorii
 * w ten sam, jednolity sposób poprzez wspólny interfejs.
 * Dzięki temu klient może np. obliczyć wartość całej kategorii nie martwiąc się
 * o to, jak głęboko zagnieżdżone są w niej produkty.
 */

public class ProductCategory implements CatalogComponent {
    private String name;
    private List<CatalogComponent> components = new ArrayList<>();

    public ProductCategory(String name) {
        this.name = name;
    }

    public void addComponent(CatalogComponent component) {
        components.add(component);
    }

    public void removeComponent(CatalogComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() {
        return components.stream()
                .mapToDouble(CatalogComponent::getPrice)
                .sum();
    }

    @Override
    public void printDetails() {
        System.out.println("Kategoria: " + name);
        for (CatalogComponent component : components) {
            component.printDetails();
        }
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 1