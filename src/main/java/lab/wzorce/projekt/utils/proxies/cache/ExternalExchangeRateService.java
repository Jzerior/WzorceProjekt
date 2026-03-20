package lab.wzorce.projekt.utils.proxies.cache;

// Tydzień 4, Wzorzec Proxy 3 (Cache Proxy)
// Reprezentuje zewnętrzne, kosztowne lub wolne API bankowe.
public class ExternalExchangeRateService implements ExchangeRateService {
    @Override
    public double getRate(String currencyCode) {
        System.out.println("[Cache Proxy] Wywołanie zewnętrznego API do pobrania kursu: " + currencyCode);

        // Symulacja pobrania z sieci
        switch (currencyCode.toUpperCase()) {
            case "USD": return 4.02;
            case "EUR": return 4.31;
            case "GBP": return 5.05;
            default: return 1.00;
        }
    }
}