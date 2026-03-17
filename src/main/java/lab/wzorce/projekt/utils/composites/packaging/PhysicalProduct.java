package lab.wzorce.projekt.utils.composites.packaging;

/**
 * Tydzień 3, Wzorzec Composite 2,
 * System Pakowania Zamówień
 * Modeluje strukturę fizycznych paczek logistycznych.
 * Wspólny interfejs sprawia, że system nie musi rozróżniać
 * przedmiotu wrzuconego luzem od wielkiego pudła zbiorczego,
 * które zawiera w sobie mniejsze pudełka.
 */

public class PhysicalProduct implements PackageComponent {
    private String name;
    private double weight;

    public PhysicalProduct(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 2