package lab.wzorce.projekt.utils.solid.isp.warehouse.bad;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Antywzorzec
 * Gruby interfejs wymuszający na urządzeniach implementację niepotrzebnych funkcji.
 */
public interface WarehouseDevice {
    void printShippingLabel(String orderId);
    void scanBarcode(String barcode);
    double weighPackage();
}