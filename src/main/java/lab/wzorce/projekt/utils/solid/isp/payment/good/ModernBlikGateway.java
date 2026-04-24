package lab.wzorce.projekt.utils.solid.isp.payment.good;

import org.springframework.stereotype.Service;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Klasa implementuje tylko ten interfejs, którego faktycznie używa.
 */
@Service
public class ModernBlikGateway implements BlikProcessor {

    @Override
    public void processBlik(String blikCode, double amount) {
        System.out.println("Przetwarzanie BLIK: " + blikCode);
    }
}