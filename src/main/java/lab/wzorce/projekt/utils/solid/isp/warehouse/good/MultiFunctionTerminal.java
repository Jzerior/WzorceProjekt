package lab.wzorce.projekt.utils.solid.isp.warehouse.good;

import org.springframework.stereotype.Component;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Urządzenie wielofunkcyjne bezpiecznie łączy kilka zsegregowanych interfejsów.
 */
@Component
public class MultiFunctionTerminal implements BarcodeScanner, LabelPrinter {

    @Override
    public void scanBarcode(String barcode) {
        System.out.println("[Terminal] Zeskanowano kod: " + barcode);
    }

    @Override
    public void printShippingLabel(String orderId) {
        System.out.println("[Terminal] Drukowanie etykiety kurierskiej dla: " + orderId);
    }
}