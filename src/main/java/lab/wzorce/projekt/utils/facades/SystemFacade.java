package lab.wzorce.projekt.utils.facades;

import lab.wzorce.projekt.utils.singletons.ShopConfigurationManager;
import lab.wzorce.projekt.utils.singletons.TaxCalculator;

// Tydzień 4, Wzorzec Facade 3
//Wzorzec Facade pozwala na uproszczenie procesu kontroli obecnych ustawień systemu poprzez wypisanie danych konfiguracyjnych
public class SystemFacade {
    private final ShopConfigurationManager config = ShopConfigurationManager.getInstance();
    private final TaxCalculator taxCalc = TaxCalculator.getInstance();

    public String getSystemStatusSummary() {
        return "Sklep: " + config.getShopName() +
                " | Waluta: " + config.getDefaultCurrency() +
                " | Aktualna stawka VAT: " + taxCalc.getCurrentTax()*100+ "%";
    }
}
//Koniec Tydzień 4, Wzorzec Facade 3