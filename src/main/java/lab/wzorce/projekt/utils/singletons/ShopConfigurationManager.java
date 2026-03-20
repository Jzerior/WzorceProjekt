package lab.wzorce.projekt.utils.singletons;

// Tydzień 1, Wzorzec Singleton 2
// Wzorzec projektowy Singleton zaimplementowany metodą podwójnego sprawdzania  z leniwą inicjalizacją.
// Zapewnia to bezpieczne wielowątkowo utworzenie instancji dopiero przy pierwszym wywołaniu, minimalizując narzut synchronizacji dzięki słowu kluczowemu volatile.
public class ShopConfigurationManager {

    private static volatile ShopConfigurationManager instance;

    private String defaultCurrency;
    private final String shopName;

    private ShopConfigurationManager() {
        this.defaultCurrency = "PLN";
        this.shopName = "Szczupak";
    }

    public static ShopConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (ShopConfigurationManager.class) {
                if (instance == null) {
                    instance = new ShopConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }
    public String getShopName() {return shopName;}

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}
// Koniec, Tydzień 1, Wzorzec Singleton 2.