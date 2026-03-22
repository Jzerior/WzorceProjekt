package lab.wzorce.projekt.utils.flyweights.delivery;

import java.util.HashMap;
import java.util.Map;

/**
 * Tydzień 4, Wzorzec Flyweight 2
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public class MapIconFactory {
    private static final Map<String, MapIcon> icons = new HashMap<>();

    public static MapIcon getIcon(String type) {
        if (!icons.containsKey(type)) {
            switch (type.toUpperCase()) {
                case "KURIER":
                    icons.put(type, new SharedMapIcon("Kurier DPD", "#FF0000"));
                    break;
                case "PACZKOMAT":
                    icons.put(type, new SharedMapIcon("Paczkomat InPost", "#FFCC00"));
                    break;
                case "POCZTA":
                    icons.put(type, new SharedMapIcon("Placówka Poczty", "#0000FF"));
                    break;
                default:
                    icons.put(type, new SharedMapIcon("Domyślny punkt", "#808080"));
            }
        }
        return icons.get(type);
    }

    public static int getIconsCreated() {
        return icons.size();
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 2