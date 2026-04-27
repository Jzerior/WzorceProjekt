package lab.wzorce.projekt.utils.solid.isp.payment.good;

import org.springframework.stereotype.Service;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Implementacja wielu dedykowanych interfejsów jednocześnie.
 */
@Service
public class AdvancedPaymentGateway implements CardProcessor, BlikProcessor {

    @Override
    public void processCreditCard(double amount) {
        System.out.println("Płatność kartą: " + amount);
    }

    @Override
    public void processBlik(String blikCode, double amount) {
        System.out.println("Płatność BLIK: " + amount);
    }
}