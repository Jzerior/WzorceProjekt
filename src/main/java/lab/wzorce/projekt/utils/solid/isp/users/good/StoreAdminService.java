package lab.wzorce.projekt.utils.solid.isp.users.good;

import org.springframework.stereotype.Service;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Serwis wstrzykujący konkretną rolę (ProductManager) zamiast grubego interfejsu.
 */
@Service
public class StoreAdminService {

    private final ProductManager productManager;

    public StoreAdminService(ProductManager productManager) {
        this.productManager = productManager;
    }

    public void runSale(String productId) {
        System.out.println("Uruchamianie promocji na produkt...");
        productManager.updateProductPrice(productId, 9.99);
    }
}