// Tydzień 3, Wzorzec Bridge 2
package lab.wzorce.projekt.utils.bridges.payments;

// Abstrakcja
public abstract class Payment {
    protected PaymentProvider provider; // Most (Bridge) do dostawcy płatności

    public Payment(PaymentProvider provider) {
        this.provider = provider;
    }

    public abstract String execute(double amount);
}
// Koniec tydzień 3, Wzorzec Bridge 2