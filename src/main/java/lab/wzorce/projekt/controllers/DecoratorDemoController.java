package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.decorators.pricing.*;
import lab.wzorce.projekt.utils.decorators.text.*;
import lab.wzorce.projekt.utils.decorators.shipping.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

// Tydzień 3, Wzorzec Decorator - Testy (1, 2, 3)
// Kontroler demonstrujący działanie wszystkich trzech przypadków użycia wzorca Decorator.
@RestController
@RequestMapping("/api/demo/decorator")
public class DecoratorDemoController {

    // PRZYKŁAD 1: Kalkulacja kosztów (Pricing)
    @GetMapping("/pricing")
    public Map<String, Object> testPricingDecorator() {
        Map<String, Object> responses = new LinkedHashMap<>();

        // Tworzymy i owijamy zamówienie
        OrderCost order = new BaseOrderCost(150.0);
        order = new GiftWrapDecorator(order);
        order = new ExpressDeliveryDecorator(order);

        responses.put("opis", order.getDescription());
        responses.put("calkowityKoszt", order.getCost());

        return responses;
    }

    // PRZYKŁAD 2: Formatowanie tekstu opisu (Text)
    @GetMapping("/text")
    public Map<String, String> testTextDecorator() {
        Map<String, String> responses = new LinkedHashMap<>();

        // Surowy tekst
        ProductDescription baseText = new BasicDescription("Zestaw noży kuchennych ze stali damasceńskiej.");
        responses.put("1_baza", baseText.getContent());

        // Tekst owinięty w pogrubienie, ostrzeżenie i znak wodny
        ProductDescription fullyDecoratedText = new PromoWatermarkDecorator(
                new WarningDecorator(
                        new HtmlBoldDecorator(baseText)
                )
        );
        responses.put("2_udekorowane", fullyDecoratedText.getContent());

        return responses;
    }

    // PRZYKŁAD 3: Etykiety wysyłkowe (Shipping)
    @GetMapping("/shipping")
    public Map<String, String> testShippingDecorator() {
        Map<String, String> responses = new LinkedHashMap<>();

        // Podstawowa etykieta z samym adresem
        ShippingLabel label = new BasicShippingLabel("Jan Kowalski, ul. Wiosenna 15, 20-001 Lublin");

        // Dodanie naklejek (szkło i ubezpieczenie)
        label = new FragileLabelDecorator(label);
        label = new InsuranceLabelDecorator(label, 5000.0);

        responses.put("wydrukowana_etykieta", label.printLabel());

        return responses;
    }
}
// Koniec, Tydzień 3, Wzorzec Decorator - Testy (1, 2, 3)