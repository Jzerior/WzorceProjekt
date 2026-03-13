// Tydzień 3, Wzorzec Bridge 2
package lab.wzorce.projekt.utils.bridges.payments;

// Konkretny Implementator A
public class BlikProvider implements PaymentProvider {
    @Override
    public String processPayment(double amount) {
        return "Przetwarzanie płatności BLIK na kwotę: " + amount + " PLN. Oczekiwanie na kod...";
    }
}
// Koniec tydzień 3, Wzorzec Bridge 2