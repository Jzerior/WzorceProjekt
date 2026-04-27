package lab.wzorce.projekt.utils.solid.lsp.loyalty;

// Tydzień 8, Zasada LSP
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.
public class LoyaltyPointsCalculator {
    public int calculate(double orderAmount) {
        if (orderAmount <= 0) {
            return 0;
        }
        return (int) (orderAmount / 10); // 1 punkt za każde 10 zł
    }
}
// Koniec, Tydzień 8, Zasada LSP