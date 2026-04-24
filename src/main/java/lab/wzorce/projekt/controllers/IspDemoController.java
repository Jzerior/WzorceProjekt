package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.solid.isp.payment.good.CheckoutService;
import lab.wzorce.projekt.utils.solid.isp.users.good.StoreAdminService;
import lab.wzorce.projekt.utils.solid.isp.warehouse.good.WarehouseFulfillmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kontroler demonstrujący działanie zasady ISP (Interface Segregation Principle).
 * Tydzień 8
 */
@RestController
@RequestMapping("/isp")
public class IspDemoController {

    private final CheckoutService checkoutService;
    private final WarehouseFulfillmentService warehouseService;
    private final StoreAdminService storeAdminService;

    public IspDemoController(CheckoutService checkoutService,
                             WarehouseFulfillmentService warehouseService,
                             StoreAdminService storeAdminService) {
        this.checkoutService = checkoutService;
        this.warehouseService = warehouseService;
        this.storeAdminService = storeAdminService;
    }

    @GetMapping("/demo")
    public String runIspDemo() {
        System.out.println("====== START DEMO ISP (Tydzień 8) ======");

        System.out.println("\n--- Przykład 1: Procesory Płatności ---");
        checkoutService.checkoutWithBlik("123456", 149.99);
        checkoutService.checkoutWithCard(299.00);

        System.out.println("\n--- Przykład 2: Urządzenia Magazynowe ---");
        warehouseService.preparePackageForShipping("KOD-987654321", "ZAM-2023-11-01");

        System.out.println("\n--- Przykład 3: Akcje Użytkowników ---");
        storeAdminService.runSale("LAPTOP-X1");

        System.out.println("\n====== KONIEC DEMO ISP ======");

        return "<h1>Demo ISP wykonane pomyślnie!</h1><p>Przejdź do konsoli aplikacji w IDE, aby zobaczyć logi z poszczególnych serwisów.</p>";
    }
}