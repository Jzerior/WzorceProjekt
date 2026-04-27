package lab.wzorce.projekt.utils.solid.isp.warehouse.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Segregowany interfejs dla urządzeń skanujących.
 */
public interface BarcodeScanner {
    void scanBarcode(String barcode);
}