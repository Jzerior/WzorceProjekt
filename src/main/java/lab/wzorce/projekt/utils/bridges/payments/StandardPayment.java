// Tydzień 3, Wzorzec Bridge 2
package lab.wzorce.projekt.utils.bridges.payments;

// Uszczegółowiona Abstrakcja A (Zwykła płatność jednorazowa)
public class StandardPayment extends Payment {
    public StandardPayment(PaymentProvider provider) {
        super(provider);
    }

    @Override
    public String execute(double amount) {
        return "[Płatność Jednorazowa] " + provider.processPayment(amount);
    }
}
// Koniec tydzień 3, Wzorzec Bridge 2