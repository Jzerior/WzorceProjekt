package lab.wzorce.projekt.utils.solid.dip.payment;

import org.springframework.stereotype.Service;

// Tydzień 8, Zasada DIP
//Konkretna implementacja klasy abstrakcyjnej, a co za tym idzie interfejsu
@Service
public class CreditCardPaymentProcessor extends BasePaymentProcessor {
    public CreditCardPaymentProcessor() {
        super("PLN");
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Przetwarzanie płatności kartą kredytową: " + amount + " " + currency);
        return true;
    }
}
// Koniec, Tydzień 8, Zasada DIP