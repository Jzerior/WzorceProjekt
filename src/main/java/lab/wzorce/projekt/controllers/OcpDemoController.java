package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.solid.ocp.abstraction.*;
import lab.wzorce.projekt.utils.solid.ocp.datadriven.DataDrivenFeeCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Tydzień 7, Zasada OCP - Kontroler testowy
@RestController
@RequestMapping("/api/demo/ocp")
public class OcpDemoController {

    @GetMapping("/test")
    public Map<String, Object> testOcp() {
        Map<String, Object> results = new LinkedHashMap<>();

        // Przygotowanie mockowych danych (korzystamy z dostępnych w Twoim projekcie Builderów)
        Product p1 = new Product.Builder().name("Wędka Karpiowa").price(new BigDecimal("120.0")).category("SPRZET_CIEZKI").build();
        Product p2 = new Product.Builder().name("Zestaw Haczyków").price(new BigDecimal("10.0")).category("AKCESORIA").build();

        OrderItem item1 = new OrderItem();
        item1.setProduct(p1); item1.setQuantity(2); item1.setUnitPrice(p1.getPrice());

        OrderItem item2 = new OrderItem();
        item2.setProduct(p2); item2.setQuantity(10); item2.setUnitPrice(p2.getPrice());

        Order order = new Order.Builder()
                .addItem(item1)
                .addItem(item2)
                .build();

        // 1. Test: OCP Poprzez Abstrakcję (System Walidacji)
        // Rozszerzamy działanie serwisu dodając obiekty, zamiast ingerować w jego kod źródłowy.
        OrderValidationService validationService = new OrderValidationService();
        validationService.addValidator(new MinOrderValueValidator(300.0)); // Oczekiwany błąd, wartość to 340 PLN (czyli przejdzie)
        validationService.addValidator(new ItemCountValidator(5));       // Oczekiwany błąd, mamy 12 przedmiotów

        List<String> validationErrors = validationService.validate(order);
        if (validationErrors.isEmpty()) {
            results.put("1_Walidacja_Poprzez_Abstrakcje", "Zamówienie poprawne");
        } else {
            results.put("1_Walidacja_Poprzez_Abstrakcje", validationErrors);
        }

        // 2. Test: OCP Poprzez Sterowanie Danymi (Kalkulator opłat manipulacyjnych)
        // Rozszerzamy działanie algorytmu zasilając go nowymi danymi (brak zmiany logiki wewnątrz kalkulatora).
        DataDrivenFeeCalculator feeCalculator = new DataDrivenFeeCalculator();
        feeCalculator.addCategoryFeeRule("SPRZET_CIEZKI", 15.0); // 15 PLN opłaty za każdą sztukę ciężkiego sprzętu
        feeCalculator.addCategoryFeeRule("AKCESORIA", 0.5);      // 0.5 PLN opłaty za każdą sztukę akcesoriów

        double totalFee = feeCalculator.calculateTotalHandlingFee(order);
        results.put("2_Oplaty_Sterowanie_Danymi", "Całkowita dodatkowa opłata manipulacyjna: " + totalFee + " PLN");

        return results;
    }
}
// Koniec, Tydzień 7, Zasada OCP