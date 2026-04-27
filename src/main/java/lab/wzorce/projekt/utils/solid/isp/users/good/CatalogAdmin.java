package lab.wzorce.projekt.utils.solid.isp.users.good;

import org.springframework.stereotype.Component;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Pracownik mający uprawnienia wyłącznie do zarządzania produktami.
 */
@Component
public class CatalogAdmin implements ProductManager {

    @Override
    public void updateProductPrice(String productId, double newPrice) {
        System.out.println("Cena produktu [" + productId + "] zmieniona na: " + newPrice);
    }
}