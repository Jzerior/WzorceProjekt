package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.User;
import lab.wzorce.projekt.utils.proxies.cache.CachedExchangeRateProxy;
import lab.wzorce.projekt.utils.proxies.cache.ExchangeRateService;
import lab.wzorce.projekt.utils.proxies.protection.FinancialReport;
import lab.wzorce.projekt.utils.proxies.protection.ReportAccessProxy;
import lab.wzorce.projekt.utils.proxies.virtual.ProductImage;
import lab.wzorce.projekt.utils.proxies.virtual.ProxyProductImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/proxy")
public class ProxyDemoController {

    @GetMapping("/virtual")
    public Map<String, String> testVirtualProxy() {
        Map<String, String> results = new LinkedHashMap<>();

        // Tworzymy pełnomocnika, na tym etapie prawdziwy obraz nie ładuje się jeszcze do pamięci
        ProductImage image = new ProxyProductImage("rower_szosowy_ultra_4k.png");

        results.put("1_status", "Obiekt ProxyProductImage został utworzony (Prawdziwe zdjęcie jeszcze nie załadowane)");
        // Wywołanie display powoduje pierwsze, leniwe załadowanie
        results.put("2_first_call", image.display());
        // Drugie wywołanie tylko korzysta z już załadowanego obiektu
        results.put("3_second_call", image.display());

        return results;
    }

    @GetMapping("/protection")
    public Map<String, String> testProtectionProxy() {
        Map<String, String> results = new LinkedHashMap<>();

        // Użycie wzorca Builder z Tygodnia 1
        User admin = new User.Builder().login("szef").privilege("admin").build();
        User regularUser = new User.Builder().login("klient").privilege("user").build();

        FinancialReport adminProxy = new ReportAccessProxy(admin);
        FinancialReport userProxy = new ReportAccessProxy(regularUser);

        results.put("proba_administratora", adminProxy.generateReport());
        results.put("proba_zwyklego_uzytkownika", userProxy.generateReport());

        return results;
    }

    @GetMapping("/cache")
    public Map<String, Object> testCacheProxy() {
        Map<String, Object> results = new LinkedHashMap<>();

        // Inicjalizujemy Proxy z Cache
        ExchangeRateService rateService = new CachedExchangeRateProxy();

        // Pierwsze pobrania (z API, logika wypisze to w konsoli serwera)
        results.put("1_USD_pierwsze_pobranie", rateService.getRate("USD"));
        results.put("2_EUR_pierwsze_pobranie", rateService.getRate("EUR"));

        // Kolejne pobranie (zadziała Cache)
        results.put("3_USD_drugie_pobranie_z_cache", rateService.getRate("USD"));
        results.put("4_EUR_drugie_pobranie_z_cache", rateService.getRate("EUR"));

        return results;
    }
}