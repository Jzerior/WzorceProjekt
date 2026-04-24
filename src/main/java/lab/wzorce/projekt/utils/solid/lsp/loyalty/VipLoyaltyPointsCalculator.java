package lab.wzorce.projekt.utils.solid.lsp.loyalty;

// Tydzień 8, Zasada LSP
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.
public class VipLoyaltyPointsCalculator extends LoyaltyPointsCalculator {
    @Override
    public int calculate(double orderAmount) {
        // Zwraca proporcjonalnie wyższą wartość
        return super.calculate(orderAmount) * 2;
    }
}
// Koniec, Tydzień 8, Zasada LSP