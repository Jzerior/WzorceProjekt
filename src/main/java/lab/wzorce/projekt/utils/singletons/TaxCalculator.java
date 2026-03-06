package lab.wzorce.projekt.utils.singletons;

public class TaxCalculator {

    // Eager initialization
    private static final TaxCalculator INSTANCE = new TaxCalculator();

    private TaxCalculator() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Instancja TaxCalculator już istnieje!");
        }
    }

    public static TaxCalculator getInstance() {
        return INSTANCE;
    }

    public double calculateVat(double netPrice) {
        return netPrice * 0.23;
    }
}