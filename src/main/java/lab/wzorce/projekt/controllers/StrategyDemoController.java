package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.strategies.discount.*;
import lab.wzorce.projekt.utils.strategies.shipping.*;
import lab.wzorce.projekt.utils.strategies.sorting.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Tydzień 6, Wzorzec Strategy 1, 2, 3 (TEST)
 * Sprawdzenie działania.
 */

@RestController
@RequestMapping("/api/demo/strategy")
public class StrategyDemoController {

    @GetMapping("/test")
    public Map<String, Object> testStrategies() {
        Map<String, Object> results = new LinkedHashMap<>();

        // 1. Zniżki (Strategy)
        PriceCalculator calculator = new PriceCalculator();
        double basePrice = 200.0;
        calculator.setDiscountStrategy(new PercentageDiscountStrategy(10));
        results.put("1_Rabat_10Procent", calculator.calculateFinalPrice(basePrice));
        calculator.setDiscountStrategy(new FixedAmountDiscountStrategy(50));
        results.put("2_Rabat_Minus50PLN", calculator.calculateFinalPrice(basePrice));

        // 2. Wysyłka (Strategy)
        DeliveryContext delivery = new DeliveryContext();
        double weight = 5.5; // kg
        delivery.setStrategy(new CourierShippingStrategy());
        results.put("3_Wysylka_Kurier", delivery.calculateCost(weight));
        delivery.setStrategy(new ParcelLockerShippingStrategy());
        results.put("4_Wysylka_Paczkomat", delivery.calculateCost(weight));

        // 3. Sortowanie (Strategy)
        ProductCatalog catalog = new ProductCatalog();
        List<Product> products = new ArrayList<>();
        products.add(new Product.Builder().name("Zanęta").price(new BigDecimal("15.0")).build());
        products.add(new Product.Builder().name("Wędka").price(new BigDecimal("150.0")).build());
        products.add(new Product.Builder().name("Haczyki").price(new BigDecimal("5.0")).build());

        catalog.setSortingStrategy(new PriceAscendingStrategy());
        catalog.displaySorted(products);
        results.put("5_Sortowanie_PoCenie", products.stream().map(p -> p.getName() + " (" + p.getPrice() + ")").toList());

        catalog.setSortingStrategy(new NameAscendingStrategy());
        catalog.displaySorted(products);
        results.put("6_Sortowanie_PoNazwie", products.stream().map(Product::getName).toList());

        return results;
    }
}

// Koniec, Tydzień 6, Wzorzec Strategy 1, 2, 3 (TEST)