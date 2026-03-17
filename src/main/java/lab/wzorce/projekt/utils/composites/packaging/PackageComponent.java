package lab.wzorce.projekt.utils.composites.packaging;

/**
 * Tydzień 3, Wzorzec Composite 2,
 * System Pakowania Zamówień
 * Modeluje strukturę fizycznych paczek logistycznych.
 * Wspólny interfejs sprawia, że system nie musi rozróżniać
 * przedmiotu wrzuconego luzem od wielkiego pudła zbiorczego,
 * które zawiera w sobie mniejsze pudełka.
 */

public interface PackageComponent {
    double getWeight();
}

// Koniec, Tydzień 3, Wzorzec Composite 2