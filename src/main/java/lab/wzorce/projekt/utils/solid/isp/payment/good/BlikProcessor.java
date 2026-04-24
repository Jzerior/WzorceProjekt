package lab.wzorce.projekt.utils.solid.isp.payment.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Segregowany interfejs dla płatności BLIK.
 */
public interface BlikProcessor {
    void processBlik(String blikCode, double amount);
}