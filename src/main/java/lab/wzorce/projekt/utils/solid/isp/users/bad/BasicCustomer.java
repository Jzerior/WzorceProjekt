package lab.wzorce.projekt.utils.solid.isp.users.bad;

import org.springframework.stereotype.Component;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Antywzorzec
 * Zwykły klient zmuszony jest do implementacji administracyjnych metod.
 */
@Component("badBasicCustomer")
public class BasicCustomer implements SystemUser {

    @Override
    public void placeOrder(String productId) {
        System.out.println("Złożono zamówienie na produkt: " + productId);
    }

    @Override
    public void leaveReview(String productId, String review) {
        System.out.println("Dodano opinię: " + review);
    }

    @Override
    public void updateProductPrice(String productId, double newPrice) {
        throw new SecurityException("Błąd: Klient nie ma uprawnień do zmiany cen!");
    }

    @Override
    public void banUser(String userId) {
        throw new SecurityException("Błąd: Klient nie ma uprawnień do banowania!");
    }
}