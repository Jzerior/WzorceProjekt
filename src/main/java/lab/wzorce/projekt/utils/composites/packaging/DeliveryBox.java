package lab.wzorce.projekt.utils.composites.packaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Tydzień 3, Wzorzec Composite 2,
 * System Pakowania Zamówień
 * Modeluje strukturę fizycznych paczek logistycznych.
 * Wspólny interfejs sprawia, że system nie musi rozróżniać
 * przedmiotu wrzuconego luzem od wielkiego pudła zbiorczego,
 * które zawiera w sobie mniejsze pudełka.
 */

public class DeliveryBox implements PackageComponent {
    private double boxEmptyWeight;
    private List<PackageComponent> contents = new ArrayList<>();

    public DeliveryBox(double boxEmptyWeight) {
        this.boxEmptyWeight = boxEmptyWeight;
    }

    public void addItem(PackageComponent item) {
        contents.add(item);
    }

    @Override
    public double getWeight() {
        double totalWeight = boxEmptyWeight;
        for (PackageComponent item : contents) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 2