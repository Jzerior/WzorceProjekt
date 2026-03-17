package lab.wzorce.projekt.utils.adapters.payments;

import lab.wzorce.projekt.utils.bridges.payments.PaymentProvider;

// Tydzień 2, Wzorzec Adapter 1
// Klasa AllegroPayAdapter implementuje istniejący w projekcie interfejs PaymentProvider, pomimo posiadana innych metod.

public class AllegroPayAdapter implements PaymentProvider {
    private ExternalAllegroPayService allegroPayService;

    public AllegroPayAdapter(ExternalAllegroPayService allegroPayService) {
        this.allegroPayService = allegroPayService;
    }

    @Override
    public String processPayment(double amount) {
        allegroPayService.commitPayment(amount, "PLN");
        return "[Allegro Pay] Płatność przetworzona pomyślnie przez adapter dla kwoty: " + amount + " PLN";
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter 1.