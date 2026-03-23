package lab.wzorce.projekt.utils.flyweights.orders;

import java.util.HashMap;
import java.util.Map;

/**
 * Tydzień 4, Wzorzec Flyweight 3
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public class OrderStatusFactory {
    private static final Map<String, OrderStatusFormatter> formatters = new HashMap<>();

    public static OrderStatusFormatter getFormatter(String statusCode) {
        if (!formatters.containsKey(statusCode)) {
            switch (statusCode) {
                case "PENDING":
                    formatters.put(statusCode, new SharedStatusFormatter("Oczekuje na wpłatę", "badge badge-warning"));
                    break;
                case "PAID":
                    formatters.put(statusCode, new SharedStatusFormatter("Opłacone", "badge badge-success"));
                    break;
                case "SHIPPED":
                    formatters.put(statusCode, new SharedStatusFormatter("Wysłane", "badge badge-info"));
                    break;
            }
        }
        return formatters.get(statusCode);
    }

    public static int countFormatters() {
        return formatters.size();
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 3
