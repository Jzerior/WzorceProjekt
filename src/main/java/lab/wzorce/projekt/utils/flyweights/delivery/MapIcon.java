package lab.wzorce.projekt.utils.flyweights.delivery;

/**
 * Tydzień 4, Wzorzec Flyweight 2
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public interface MapIcon {
    String draw(String trackingId, double lat, double lng);
}

// Koniec, Tydzień 4, Wzorzec Flyweight 2
