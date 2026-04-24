package lab.wzorce.projekt.utils.solid.isp.users.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Interfejs dedykowany tylko do robienia zakupów.
 */
public interface Buyer {
    void placeOrder(String productId);
}