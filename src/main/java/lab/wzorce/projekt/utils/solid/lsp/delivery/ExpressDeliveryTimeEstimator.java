package lab.wzorce.projekt.utils.solid.lsp.delivery;

// Tydzień 8, Zasada LSP
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.
public class ExpressDeliveryTimeEstimator extends DeliveryTimeEstimator {
    @Override
    public int estimateDays(double distanceKm) {
        int baseDays = super.estimateDays(distanceKm);

        return Math.max(1, baseDays / 2); // Zmniejszamy czas o połowę
    }
}
// Koniec, Tydzień 8, Zasada LSP