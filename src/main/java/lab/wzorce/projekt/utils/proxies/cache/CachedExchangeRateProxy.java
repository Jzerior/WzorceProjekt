package lab.wzorce.projekt.utils.proxies.cache;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec Proxy 3 (Cache Proxy)
// Pełnomocnik buforujący, który zapamiętuje wyniki z API zewnętrznego,
// aby nie odpytywać go wielokrotnie o tę samą walutę.
public class CachedExchangeRateProxy implements ExchangeRateService {
    private final ExternalExchangeRateService realService;
    private final Map<String, Double> rateCache;

    public CachedExchangeRateProxy() {
        this.realService = new ExternalExchangeRateService();
        this.rateCache = new HashMap<>();
    }

    @Override
    public double getRate(String currencyCode) {
        String code = currencyCode.toUpperCase();

        if (!rateCache.containsKey(code)) {
            // Jeśli waluty nie ma w cache, delegujemy pobranie do prawdziwego serwisu
            double rate = realService.getRate(code);
            rateCache.put(code, rate);
            return rate;
        }

        // Jeśli wartość jest w cache, po prostu ją zwracamy
        System.out.println("[Cache Proxy] Zwracanie kursu " + code + " prosto z pamięci cache.");
        return rateCache.get(code);
    }
}