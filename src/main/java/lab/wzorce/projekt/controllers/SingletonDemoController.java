package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.singletons.AuditLogger;
import lab.wzorce.projekt.utils.singletons.ShopConfigurationManager;
import lab.wzorce.projekt.utils.singletons.TaxCalculator;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/demo/singleton")
public class SingletonDemoController {

    @GetMapping("/tax-calculator")
    public Map<String, Object> testTaxCalculator(@RequestParam(defaultValue = "100.0") double netPrice) {
        double vat = TaxCalculator.getInstance().calculateVat(netPrice);
        AuditLogger.INSTANCE.log("Obliczono VAT dla kwoty: " + netPrice); //

        return Map.of(
                "pattern", "Eager Initialization",
                "netPrice", netPrice,
                "vatAmount", vat,
                "grossPrice", netPrice + vat
        );
    }

    @GetMapping("/config")
    public Map<String, String> getConfiguration() {
        return Map.of(
                "pattern", "Lazy Initialization (Double-Checked Locking)",
                "currentCurrency", ShopConfigurationManager.getInstance().getDefaultCurrency() //
        );
    }

    @PostMapping("/config/currency")
    public Map<String, String> updateCurrency(@RequestParam String currency) {
        ShopConfigurationManager config = ShopConfigurationManager.getInstance();
        String oldCurrency = config.getDefaultCurrency();
        config.setDefaultCurrency(currency); //

        AuditLogger.INSTANCE.log("Zmiana waluty z " + oldCurrency + " na " + currency); //

        return Map.of(
                "status", "Updated",
                "oldCurrency", oldCurrency,
                "newCurrency", currency
        );
    }

    @PostMapping("/audit/log")
    public Map<String, String> testAuditLog(@RequestBody String message) {
        AuditLogger.INSTANCE.log("Ręczny wpis: " + message); //

        return Map.of(
                "pattern", "Enum Singleton",
                "status", "Logged to console",
                "message", message
        );
    }
}