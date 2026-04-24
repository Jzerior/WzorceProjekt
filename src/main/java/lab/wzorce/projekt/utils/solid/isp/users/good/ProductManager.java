package lab.wzorce.projekt.utils.solid.isp.users.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Interfejs administracyjny dla osób zarządzających katalogiem produktów.
 */
public interface ProductManager {
    void updateProductPrice(String productId, double newPrice);
}