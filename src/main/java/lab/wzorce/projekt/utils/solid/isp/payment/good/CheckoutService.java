package lab.wzorce.projekt.utils.solid.isp.payment.good;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Serwis wstrzykujący precyzyjnie wydzielone, mniejsze zależności.
 */
@Service
public class CheckoutService {

    private final BlikProcessor blikProcessor;
    private final CardProcessor cardProcessor;

    public CheckoutService(
            @Qualifier("modernBlikGateway") BlikProcessor blikProcessor,
            @Qualifier("advancedPaymentGateway") CardProcessor cardProcessor) {
        this.blikProcessor = blikProcessor;
        this.cardProcessor = cardProcessor;
    }

    public void checkoutWithBlik(String code, double amount) {
        blikProcessor.processBlik(code, amount);
    }

    public void checkoutWithCard(double amount) {
        cardProcessor.processCreditCard(amount);
    }
}