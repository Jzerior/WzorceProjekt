package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.solid.lsp.delivery.DeliveryTimeEstimator;
import lab.wzorce.projekt.utils.solid.lsp.delivery.ExpressDeliveryTimeEstimator;
import lab.wzorce.projekt.utils.solid.lsp.loyalty.LoyaltyPointsCalculator;
import lab.wzorce.projekt.utils.solid.lsp.loyalty.VipLoyaltyPointsCalculator;
import lab.wzorce.projekt.utils.solid.lsp.notification.OrderNotification;
import lab.wzorce.projekt.utils.solid.lsp.notification.ShippedOrderNotification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Tydzień 8, Zasada LSP (TEST)
// Zasada podstawienia Liskov mówi o tym, że obiekty klasy bazowej powinny móc
// być zastąpione obiektami klas pochodnych bez niszczenia poprawności programu.

@RestController
@RequestMapping("/solid/lsp")
public class LspDemoController {

    @GetMapping("/demo")
    public String showLiskovSubstitution() {
        StringBuilder report = new StringBuilder("<h3>Demonstracja Liskov Substitution Principle (LSP)</h3>");

        // 1. Test dostawy
        report.append("<h4>1. Szacowanie czasu dostawy (Dystans: 350 km)</h4>");
        List<DeliveryTimeEstimator> estimators = List.of(
                new DeliveryTimeEstimator(),
                new ExpressDeliveryTimeEstimator()
        );

        for (DeliveryTimeEstimator estimator : estimators) {
            report.append("Klasa ").append(estimator.getClass().getSimpleName())
                    .append(" wyliczyła dni: ").append(estimator.estimateDays(350)).append("<br/>");
        }

        // 2. Test punktów lojalnościowych
        report.append("<h4>2. Naliczanie punktów (Zamówienie: 150 PLN)</h4>");
        List<LoyaltyPointsCalculator> calculators = List.of(
                new LoyaltyPointsCalculator(),
                new VipLoyaltyPointsCalculator()
        );

        for (LoyaltyPointsCalculator calculator : calculators) {
            report.append("Klasa ").append(calculator.getClass().getSimpleName())
                    .append(" przyznała punktów: ").append(calculator.calculate(150.0)).append("<br/>");
        }

        // 3. Test powiadomień
        report.append("<h4>3. Powiadomienia o zamówieniu</h4>");
        List<OrderNotification> notifications = List.of(
                new OrderNotification(),
                new ShippedOrderNotification("http://paczka.pl/12345")
        );

        for (OrderNotification notification : notifications) {
            report.append("Wynik (").append(notification.getClass().getSimpleName()).append("): ")
                    .append(notification.generateMessage("ORD-998")).append("<br/>");
        }

        return report.toString();
    }
}
// Koniec, Tydzień 8, Zasada LSP (TEST)