package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.flyweights.catalog.BadgeFactory;
import lab.wzorce.projekt.utils.flyweights.catalog.ProductBadge;
import lab.wzorce.projekt.utils.flyweights.delivery.MapIcon;
import lab.wzorce.projekt.utils.flyweights.delivery.MapIconFactory;
import lab.wzorce.projekt.utils.flyweights.orders.OrderStatusFactory;
import lab.wzorce.projekt.utils.flyweights.orders.OrderStatusFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Tydzień 4, Wzorzec Flyweight 1, 2, 3 (TEST)
 * Sprawdzenie działania.
 */

@RestController
@RequestMapping("/api/demo/flyweight")
public class FlyweightDemoController {

    private final Random random = new Random();

    @GetMapping("/delivery")
    public Map<String, Object> testDeliveryMap() {
        String[] types = {"KURIER", "PACZKOMAT", "POCZTA"};
        int totalParcels = 10000;

        for (int i = 0; i < totalParcels; i++) {
            String type = types[random.nextInt(types.length)];
            MapIcon icon = MapIconFactory.getIcon(type);
            icon.draw("TRACK-10" + i, 51.0 + random.nextDouble(), 19.0 + random.nextDouble());
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("opis", "Wygenerowano przesyłki na mapie.");
        result.put("wyrenderowano_paczek", totalParcels);
        result.put("utworzonych_obiektow_w_pamieci", MapIconFactory.getIconsCreated());
        return result;
    }

    @GetMapping("/catalog")
    public Map<String, Object> testCatalogBadges() {
        ProductBadge badgeBestseller = BadgeFactory.getBadge("BESTSELLER");
        ProductBadge badgeSale = BadgeFactory.getBadge("SALE");

        String p1 = badgeBestseller.renderBadge("Wędka Karpiowa 3000", 350.0);
        String p2 = badgeSale.renderBadge("Zestaw Haczyków", 15.50);
        String p3 = badgeBestseller.renderBadge("Namiot Wędkarski", 890.0);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("produkt_1", p1);
        result.put("produkt_2", p2);
        result.put("produkt_3", p3);
        result.put("utworzonych_w_pamieci", BadgeFactory.getCacheSize());
        return result;
    }

    @GetMapping("/orders")
    public String testOrderTable() {
        String[] statuses = {"PENDING", "PAID", "SHIPPED"};

        StringBuilder html = new StringBuilder();
        html.append("<h3>Historia Ostatnich Zamówień</h3>");
        html.append("<table border='1' cellpadding='5'><tr><th>Nr Zamówienia</th><th>Data</th><th>Status</th></tr>");

        for (int i = 1; i <= 10; i++) {
            String status = statuses[random.nextInt(statuses.length)];
            OrderStatusFormatter formatter = OrderStatusFactory.getFormatter(status);

            html.append(formatter.formatRow("ZAM-2026-" + i, "2026-03-" + (10 + i)));
        }

        html.append("</table>");
        html.append("<br><p>Liczba unikalnych formaterów statusu w pamięci RAM: <b>")
                .append(OrderStatusFactory.countFormatters())
                .append("</b></p>");

        return html.toString();
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 1, 2, 3 (TEST)