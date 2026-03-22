package lab.wzorce.projekt.utils.flyweights.orders;

/**
 * Tydzień 4, Wzorzec Flyweight 3
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public interface OrderStatusFormatter {
    String formatRow(String orderId, String date);
}

// Koniec, Tydzień 4, Wzorzec Flyweight 3
