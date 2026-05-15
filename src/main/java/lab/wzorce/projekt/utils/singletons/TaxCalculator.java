package lab.wzorce.projekt.utils.singletons;

// Tydzień 1, Wzorzec Singleton 3
// Wzorzec projektowy Singleton zaimplementowany metodą zachłannej inicjalizacji. Instancja jest tworzona już podczas ładowania klasy,
// a prywatny konstruktor zawiera dodatkowe zabezpieczenie przed próbą utworzenia kolejnego obiektu za pomocą mechanizmu refleksji.
public class TaxCalculator {

    private static final TaxCalculator INSTANCE = new TaxCalculator();

    private TaxCalculator() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Instancja TaxCalculator już istnieje!");
        }
    }

    public static TaxCalculator getInstance() {
        return INSTANCE;
    }

    private static final double VAT_RATE = 0.23;

    public double calculateVat(double netPrice) {
        return netPrice * VAT_RATE;
    }
    public double getCurrentTax(){return VAT_RATE;}
}
// Koniec, Tydzień 1, Wzorzec Singleton 3.