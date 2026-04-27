package lab.wzorce.projekt.utils.solid.isp.warehouse.good;

import org.springframework.stereotype.Component;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Klasa implementuje tylko ten interfejs, do którego została stworzona.
 */
@Component("goodBarcodeScanner")
public class BasicBarcodeScanner implements BarcodeScanner {

    @Override
    public void scanBarcode(String barcode) {
        System.out.println("Zeskanowano kod kreskowy: " + barcode);
    }
}