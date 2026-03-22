package lab.wzorce.projekt.utils.flyweights.delivery;

/**
 * Tydzień 4, Wzorzec Flyweight 2
 * Wzorzec Flyweight wspiera obsługe dużej liczby obiektów.
 * Polega na podziale stanu obiektu na dwie części:
 * - wewnętrzny - niezmienny, współdzielony przez wiele obiektów,
 * - zewnętrzny - unikalny dla każdego obiektu.
 */

public class SharedMapIcon implements MapIcon {
    private final String iconType;
    private final String color;
    private final byte[] heavyImageData;

    public SharedMapIcon(String iconType, String color) {
        this.iconType = iconType;
        this.color = color;
        this.heavyImageData = new byte[50000];
        System.out.println("   [Flyweight] Tworzenie w pamięci nowej grafiki dla: " + iconType);
    }

    @Override
    public String draw(String trackingId, double lat, double lng) {
        return "Rysowanie [" + iconType + " / " + color + "] dla paczki "
                + trackingId + " w punkcie (" + lat + ", " + lng + ")";
    }
}

// Koniec, Tydzień 4, Wzorzec Flyweight 2
