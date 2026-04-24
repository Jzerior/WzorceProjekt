package lab.wzorce.projekt.utils.solid.isp.users.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Interfejs dedykowany tylko do wystawiania opinii.
 */
public interface Reviewer {
    void leaveReview(String productId, String review);
}