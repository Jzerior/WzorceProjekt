package lab.wzorce.projekt.utils.solid.isp.users.good;

import org.springframework.stereotype.Component;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Klasa implementuje tylko te interfejsy, z których realnie korzysta.
 */
@Component("goodStandardCustomer")
public class StandardCustomer implements Buyer, Reviewer {

    @Override
    public void placeOrder(String productId) {
        System.out.println("Złożono zamówienie na produkt: " + productId);
    }

    @Override
    public void leaveReview(String productId, String review) {
        System.out.println("Dodano opinię: " + review);
    }
}