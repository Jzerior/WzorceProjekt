// Tydzień 3, Wzorzec Bridge 2
package lab.wzorce.projekt.utils.bridges.payments;

// Uszczegółowiona Abstrakcja B (Płatność ratalna)
public class InstallmentPayment extends Payment {
    private int months;

    public InstallmentPayment(PaymentProvider provider, int months) {
        super(provider);
        this.months = months;
    }

    @Override
    public String execute(double amount) {
        double monthlyInstallment = Math.round((amount / months) * 100.0) / 100.0;
        String info = "[Płatność na " + months + " rat, kwota raty: " + monthlyInstallment + " PLN] ";
        return info + provider.processPayment(amount);
    }
}
// Koniec tydzień 3, Wzorzec Bridge 2