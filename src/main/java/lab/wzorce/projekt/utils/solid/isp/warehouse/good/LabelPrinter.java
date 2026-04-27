package lab.wzorce.projekt.utils.solid.isp.warehouse.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Segregowany interfejs dla urządzeń mogących drukować etykiety.
 */
public interface LabelPrinter {
    void printShippingLabel(String orderId);
}