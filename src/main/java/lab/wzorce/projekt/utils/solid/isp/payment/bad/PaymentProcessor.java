package lab.wzorce.projekt.utils.solid.isp.payment.bad;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Antywzorzec
 * Gruby interfejs zawierający wszystkie możliwe metody płatności.
 */
public interface PaymentProcessor {
    void processCreditCard(double amount);
    void processBlik(String blikCode, double amount);
    void processCrypto(String walletAddress, double amount);
}