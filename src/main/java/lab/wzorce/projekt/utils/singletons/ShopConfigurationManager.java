package lab.wzorce.projekt.utils.singletons;

public class ShopConfigurationManager {

    //Lazy initialization
    private static volatile ShopConfigurationManager instance;

    private String defaultCurrency;

    private ShopConfigurationManager() {
        this.defaultCurrency = "PLN";
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

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}