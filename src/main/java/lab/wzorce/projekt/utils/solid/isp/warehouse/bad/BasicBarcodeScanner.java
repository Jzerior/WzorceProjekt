package lab.wzorce.projekt.utils.solid.isp.warehouse.bad;

import org.springframework.stereotype.Component;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Antywzorzec
 * Prosty skaner jest zmuszony implementować ważenie i drukowanie, rzucając wyjątki.
 */
@Component("badBarcodeScanner")
public class BasicBarcodeScanner implements WarehouseDevice {

    @Override
    public void printShippingLabel(String orderId) {
        throw new UnsupportedOperationException("Błąd: Skaner nie posiada funkcji drukowania!");
    }

    @Override
    public void scanBarcode(String barcode) {
        System.out.println("Zeskanowano kod kreskowy: " + barcode);
    }

    @Override
    public double weighPackage() {
        throw new UnsupportedOperationException("Błąd: Skaner nie posiada wagi!");
    }
}