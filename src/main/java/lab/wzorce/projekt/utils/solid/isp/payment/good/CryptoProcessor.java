package lab.wzorce.projekt.utils.solid.isp.payment.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Segregowany interfejs dla płatności krypto.
 */
public interface CryptoProcessor {
    void processCrypto(String walletAddress, double amount);
}