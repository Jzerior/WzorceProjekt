package lab.wzorce.projekt.utils.flyweights.catalog;

import java.util.HashMap;
import java.util.Map;

/**
 * Tydzień 4, Wzorzec Flyweight 1
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public class BadgeFactory {
    private static final Map<String, ProductBadge> badges = new HashMap<>();

    public static ProductBadge getBadge(String type) {
        if (!badges.containsKey(type)) {
            switch (type) {
                case "BESTSELLER":
                    badges.put(type, new GraphicProductBadge("Bestseller", "#FFA500", "⭐"));
                    break;
                case "NEW":
                    badges.put(type, new GraphicProductBadge("Nowość", "#008000", "🆕"));
                    break;
                case "SALE":
                    badges.put(type, new GraphicProductBadge("Wyprzedaż", "#FF0000", "🔥"));
                    break;
            }
        }
        return badges.get(type);
    }

    public static int getCacheSize() {
        return badges.size();
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 1
