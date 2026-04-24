package lab.wzorce.projekt.utils.solid.isp.warehouse.good;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Serwis polegający tylko na tych interfejsach, których realnie używa.
 */
@Service
public class WarehouseFulfillmentService {

    private final BarcodeScanner scanner;
    private final LabelPrinter printer;

    public WarehouseFulfillmentService(
            @Qualifier("goodBarcodeScanner") BarcodeScanner scanner,
            LabelPrinter printer) {
        this.scanner = scanner;
        this.printer = printer;
    }

    public void preparePackageForShipping(String barcode, String orderId) {
        scanner.scanBarcode(barcode);
        printer.printShippingLabel(orderId);
    }
}