package lab.wzorce.projekt.utils.solid.isp.users.bad;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Antywzorzec
 * Gruby interfejs definiujący wszystkie możliwe operacje w systemie.
 */
public interface SystemUser {
    void placeOrder(String productId);
    void leaveReview(String productId, String review);
    void updateProductPrice(String productId, double newPrice);
    void banUser(String userId);
}