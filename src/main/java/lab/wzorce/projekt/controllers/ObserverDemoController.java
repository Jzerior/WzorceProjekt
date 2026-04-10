package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.observers.stock.*;
import lab.wzorce.projekt.utils.observers.order.*;
import lab.wzorce.projekt.utils.observers.newsletter.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Tydzień 6, Wzorzec Observer - Testy
 */
@RestController
@RequestMapping("/api/demo/observer")
public class ObserverDemoController {

    @GetMapping("/stock")
    public Map<String, String> testStockObserver() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Tworzymy obserwowany obiekt (Subject)
        StockItem fishingRod = new StockItem("Wędka Karpiowa Pro", false);

        // 2. Tworzymy obserwatorów (Observers)
        Observer customer1 = new CustomerSubscriber("Janek");
        Observer customer2 = new CustomerSubscriber("Anna");
        Observer manager = new StoreManagerSubscriber("Kierownik Tomek");

        // 3. Rejestrujemy obserwatorów
        fishingRod.attach(customer1);
        fishingRod.attach(customer2);
        fishingRod.attach(manager);

        results.put("01_Status", "Produkt niedostępny. Subskrybenci dodani. Symulujemy dostawę...");

        // 4. Zmiana stanu - produkt staje się dostępny (powiadomi wszystkich obserwatorów)
        fishingRod.setInStock(true);

        results.put("02_Powiadomienie_Klient1", customer1.getLastNotification());
        results.put("03_Powiadomienie_Klient2", customer2.getLastNotification());
        results.put("04_Powiadomienie_Manager", manager.getLastNotification());

        // 5. Jeden z klientów kupuje wędkę i wypisuje się z powiadomień
        fishingRod.detach(customer1);

        // 6. Towar znów się wyprzedał
        fishingRod.setInStock(false);

        results.put("05_Status", "Klient1 odpięty. Wędka znów wyprzedana (tylko manager dostał alert).");
        results.put("06_Powiadomienie_Manager", manager.getLastNotification());
        results.put("07_Powiadomienie_Klient2", customer2.getLastNotification() + " (bez zmian, klient powiadamiany tylko o powrotach)");

        return results;
    }

    @GetMapping("/order")
    public Map<String, String> testOrderObserver() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Inicjalizacja trackera zamówienia (Subject)
        OrderStatusTracker tracker = new OrderStatusTracker("ZAM-2026-991", "NOWE");

        // 2. Tworzenie obserwatorów (kanały komunikacji)
        OrderObserver email = new EmailOrderObserver("klient@przyklad.pl");
        OrderObserver sms = new SmsOrderObserver("+48 123 456 789");
        OrderObserver push = new PushOrderObserver("iPhone-15-Pro-Klienta");

        // Klient chce otrzymywać powiadomienia e-mail oraz push na telefon, ale na razie nie SMS
        tracker.attach(email);
        tracker.attach(push);

        results.put("01_Status", "Utworzono zamówienie. Podpięto E-MAIL i PUSH.");

        // 3. Zmiana statusu na OPŁACONE
        tracker.setStatus("OPŁACONE");

        results.put("02_Log_Email", email.getLog());
        results.put("03_Log_Push", push.getLog());

        // 4. Klient prosi o włączenie SMS-ów, ale wyłącza Push
        tracker.attach(sms);
        tracker.detach(push);
        results.put("04_Status", "Zmiana preferencji: Podpięto SMS, odpięto PUSH.");

        // 5. Zmiana statusu na WYSŁANE
        tracker.setStatus("WYSŁANE");

        results.put("05_Log_Email", email.getLog());
        results.put("06_Log_Sms", sms.getLog());
        results.put("07_Log_Push", push.getLog() + " (Stary log, brak aktualizacji)");

        return results;
    }

    @GetMapping("/newsletter")
    public Map<String, String> testNewsletterObserver() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Tworzymy wydawcę (Subject)
        PromoNewsletter newsletter = new PromoNewsletter();

        // 2. Tworzymy czytelników (Observers)
        NewsletterSubscriber kowalski = new RetailCustomer("Jan Kowalski");
        NewsletterSubscriber nowak = new RetailCustomer("Anna Nowak");
        NewsletterSubscriber wedkarzPro = new WholesalePartner("Wędkarz-Pro Sp. z o.o.");

        // 3. Rejestracja czytelników
        newsletter.subscribe(kowalski);
        newsletter.subscribe(nowak);
        newsletter.subscribe(wedkarzPro);

        results.put("01_Status", "Zarejestrowano 2 klientów detalicznych i 1 hurtowego.");

        // 4. Publikacja pierwszego wydania
        newsletter.publishIssue("Wyprzedaż Wiosenna!", "Wędki tańsze o 15% z kodem WIOSNA.");

        results.put("02_Odbiorca_Kowalski", kowalski.getLog());
        results.put("03_Odbiorca_Nowak", nowak.getLog());
        results.put("04_Odbiorca_WedkarzPro", wedkarzPro.getLog());

        // 5. Jeden z klientów detalicznych wypisuje się z newslettera
        newsletter.unsubscribe(nowak);
        results.put("05_Status", "Klient Anna Nowak wypisuje się z subskrypcji.");

        // 6. Publikacja kolejnego wydania
        newsletter.publishIssue("Nowa dostawa z Japonii", "Dotarły nowe plecionki i woblery premium.");

        results.put("06_Odbiorca_Kowalski", kowalski.getLog());
        results.put("07_Odbiorca_Nowak", nowak.getLog() + " (Stary log, klient wypisany, nie dostał nowej wiadomości)");
        results.put("08_Odbiorca_WedkarzPro", wedkarzPro.getLog());

        return results;
    }
}
// Koniec, Tydzień 6, Wzorzec Observer - Testy