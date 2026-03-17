package lab.wzorce.projekt.utils.adapters.payments;

public class ExternalAllegroPayService {
    public void commitPayment(double value, String currency) {
        System.out.println("Allegro Pay API: Autoryzacja transakcji: " + value + " " + currency);
    }
}