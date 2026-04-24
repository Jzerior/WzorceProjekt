package lab.wzorce.projekt.utils.solid.lsp.delivery;

// Tydzień 8, Zasada LSP
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.
public class DeliveryTimeEstimator {
    public int estimateDays(double distanceKm) {
        if (distanceKm < 0) {
            throw new IllegalArgumentException("Dystans nie może być ujemny");
        }
        return (int) (distanceKm / 100) + 1; // 1 dzień za każde 100km + 1 dzień obsługi
    }
}
// Koniec, Tydzień 8, Zasada LSP