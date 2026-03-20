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

    public double calculateVat(double netPrice) {
        return netPrice * 0.23;
    }
    public double getCurrentTax(){return 0.23;}
}
// Koniec, Tydzień 1, Wzorzec Singleton 3.