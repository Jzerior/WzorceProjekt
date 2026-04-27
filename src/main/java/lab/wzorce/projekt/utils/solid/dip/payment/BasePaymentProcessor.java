package lab.wzorce.projekt.utils.solid.dip.payment;

// Tydzień 8, Zasada DIP
//Klasa abstrakcyjna, implementująca bazową logikę
public abstract class BasePaymentProcessor implements PaymentProcessor {
    protected String currency;

    public BasePaymentProcessor(String currency) {
        this.currency = currency;
    }

    @Override
    public abstract boolean processPayment(double amount);
}
// Koniec, Tydzień 8, Zasada DIP