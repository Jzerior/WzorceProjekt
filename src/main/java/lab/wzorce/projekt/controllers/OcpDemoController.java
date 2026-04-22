package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.solid.ocp.abstraction.*;
import lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty.BasePointsRule;
import lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty.BigOrderBonusRule;
import lab.wzorce.projekt.utils.solid.ocp.abstraction.loyalty.LoyaltyRewardService;
import lab.wzorce.projekt.utils.solid.ocp.datadriven.DataDrivenFeeCalculator;
import lab.wzorce.projekt.utils.solid.ocp.datadriven.DataDrivenReturnPolicy;
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

        // Przygotowanie mockowych danych
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

        // 3. Test: OCP Poprzez Abstrakcję (Kalkulator Punktów Lojalnościowych)
        // Rozszerzamy system o nowe promocje punktowe bez dotykania klasy LoyaltyRewardService.
        LoyaltyRewardService loyaltyService = new LoyaltyRewardService();
        loyaltyService.addRule(new BasePointsRule()); // Domyślna zasada (1 pkt za każde 10 PLN)
        loyaltyService.addRule(new BigOrderBonusRule(300.0, 50)); // Bonus promocyjny

        int earnedPoints = loyaltyService.calculateTotalPoints(order);
        results.put("3_Punkty_Lojalnosciowe_Poprzez_Abstrakcje",
                "Klient zdobył łącznie: " + earnedPoints + " punktów lojalnościowych");

        // 4. Test: OCP Poprzez Sterowanie Danymi (Polityka Zwrotów)
        // Rozszerzamy działanie kalkulatora zwrotów zasilając go nowymi regułami z zewnątrz.
        DataDrivenReturnPolicy returnPolicy = new DataDrivenReturnPolicy(14); // Domyślnie 14 dni na zwrot

        // Konfigurujemy zachowanie systemu poprzez dane
        returnPolicy.addCategoryReturnRule("SPRZET_CIEZKI", 30);
        returnPolicy.addCategoryReturnRule("AKCESORIA", 7);
        returnPolicy.addCategoryReturnRule("ODZIEZ_BIELIZNA", 0);

        int daysForProduct1 = returnPolicy.calculateReturnDays(p1);
        int daysForProduct2 = returnPolicy.calculateReturnDays(p2);

        // Przykładowy produkt bez zdefiniowanej reguły (użyje domyślnych 14 dni)
        Product p3 = new Product.Builder().name("Zwykła żyłka").price(new java.math.BigDecimal("25.0")).category("INNE").build();
        int daysForProduct3 = returnPolicy.calculateReturnDays(p3);

        results.put("4_Zwroty_Sterowanie_Danymi",
                "Dni na zwrot dla '" + p1.getName() + "': " + daysForProduct1 + " | " +
                        "Dni na zwrot dla '" + p2.getName() + "': " + daysForProduct2 + " | " +
                        "Dni na zwrot dla '" + p3.getName() + "': " + daysForProduct3);

        return results;
    }
}
// Koniec, Tydzień 7, Zasada OCP