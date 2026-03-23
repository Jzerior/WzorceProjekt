package lab.wzorce.projekt.utils.flyweights.catalog;

/**
 * Tydzień 4, Wzorzec Flyweight 1
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public interface ProductBadge {
    String renderBadge(String productName, double currentPrice);
}

// Koniec, Tydzień 4, Wzorzec Flyweight 1
