package lab.wzorce.projekt.utils.flyweights.orders;

/**
 * Tydzień 4, Wzorzec Flyweight 3
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public class SharedStatusFormatter implements OrderStatusFormatter {
    private final String translatedName;
    private final String cssClass;

    public SharedStatusFormatter(String translatedName, String cssClass) {
        this.translatedName = translatedName;
        this.cssClass = cssClass;
    }

    @Override
    public String formatRow(String orderId, String date) {
        return "<tr><td>" + orderId + "</td><td>" + date + "</td><td><span class='"
                + cssClass + "'>" + translatedName + "</span></td></tr>";
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 3
