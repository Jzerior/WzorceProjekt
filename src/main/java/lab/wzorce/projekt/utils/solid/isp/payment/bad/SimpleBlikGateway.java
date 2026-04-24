package lab.wzorce.projekt.utils.solid.isp.payment.bad;

import org.springframework.stereotype.Service;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Antywzorzec
 * Klasa zmuszona do implementacji nieużywanych metod (karty, krypto).
 */
@Service
public class SimpleBlikGateway implements PaymentProcessor {

    @Override
    public void processCreditCard(double amount) {
        throw new UnsupportedOperationException("Karty nie są obsługiwane");
    }

    @Override
    public void processBlik(String blikCode, double amount) {
        System.out.println("Przetwarzanie BLIK: " + blikCode);
    }

    @Override
    public void processCrypto(String walletAddress, double amount) {
        throw new UnsupportedOperationException("Krypto nie jest obsługiwane");
    }
}