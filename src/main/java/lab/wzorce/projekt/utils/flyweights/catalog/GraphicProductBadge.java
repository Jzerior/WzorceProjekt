package lab.wzorce.projekt.utils.flyweights.catalog;

/**
 * Tydzień 4, Wzorzec Flyweight 1
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public class GraphicProductBadge implements ProductBadge {
    private final String label;
    private final String hexColor;
    private final String iconCode;

    public GraphicProductBadge(String label, String hexColor, String iconCode) {
        this.label = label;
        this.hexColor = hexColor;
        this.iconCode = iconCode;
        System.out.println("   [Flyweight] Inicjalizacja styli dla: " + label);
    }

    @Override
    public String renderBadge(String productName, double currentPrice) {
        return "<span style='color:" + hexColor + "'>[" + iconCode + " " + label + "]</span> "
                + productName + " (Cena: " + currentPrice + " PLN)";
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 1
