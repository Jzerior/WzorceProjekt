package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.singletons.AuditLogger;
import lab.wzorce.projekt.utils.singletons.ShopConfigurationManager;
import lab.wzorce.projekt.utils.singletons.TaxCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/singleton")
public class SingletonDemoController {

    @GetMapping
    public String testSingletons() {
        double vat = TaxCalculator.getInstance().calculateVat(100.0);

        ShopConfigurationManager config = ShopConfigurationManager.getInstance();
        config.setDefaultCurrency("EUR");

        AuditLogger.INSTANCE.log("Użytkownik przetestował wzorce projektowe.");

        return "Podatek VAT od 100: " + vat +
                ", Aktualna waluta sklepu: " + ShopConfigurationManager.getInstance().getDefaultCurrency();
    }
}