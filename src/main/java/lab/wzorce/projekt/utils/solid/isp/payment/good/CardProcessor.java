package lab.wzorce.projekt.utils.solid.isp.payment.good;

/**
 * Tydzień 8
 * Zasada projektowa: ISP - Refaktoryzacja
 * Segregowany interfejs dla płatności kartą.
 */
public interface CardProcessor {
    void processCreditCard(double amount);
}