// Tydzień 3, Wzorzec Bridge 2
package lab.wzorce.projekt.utils.bridges.payments;

// Konkretny Implementator B
public class PayPalProvider implements PaymentProvider {
    @Override
    public String processPayment(double amount) {
        return "Przekierowanie do systemu PayPal. Pobieranie kwoty: " + amount + " PLN.";
    }
}
// Koniec tydzień 3, Wzorzec Bridge 2