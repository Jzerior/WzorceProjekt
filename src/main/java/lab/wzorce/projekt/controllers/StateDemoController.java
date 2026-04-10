package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.states.order.OrderContext;
import lab.wzorce.projekt.utils.states.player.MediaPlayer;
import lab.wzorce.projekt.utils.states.ticket.SupportTicket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

// Tydzień 7, Wzorzec State 1, 2, 3 (TEST)
@RestController
@RequestMapping("/api/demo/state")
public class StateDemoController {

    // Przykład 1: Status Zamówienia
    @GetMapping("/order")
    public Map<String, String> testOrderState() {
        Map<String, String> results = new LinkedHashMap<>();

        OrderContext order = new OrderContext("ZAM-2026-001");
        results.put("1_Poczatek", "Status: " + order.getStatus());

        order.ship();
        results.put("2_Proba_Wysylki", "Status po błędnej próbie wysyłki: " + order.getStatus());

        order.pay();
        results.put("3_Oplacenie", "Status po opłaceniu: " + order.getStatus());

        order.cancel();
        results.put("4_Anulowanie", "Status po anulowaniu zrezygnowanym po opłaceniu: " + order.getStatus());

        return results;
    }

    // Przykład 2: Odtwarzacz Wideo
    @GetMapping("/player")
    public Map<String, String> testPlayerState() {
        Map<String, String> results = new LinkedHashMap<>();

        MediaPlayer player = new MediaPlayer("Szkolenie: Jak łowić karpie - Odcinek 1");
        results.put("1_Poczatek", player.getStatus());

        player.pause(); // Błąd
        results.put("2_Proba_Pauzy", player.getStatus());

        player.play(); // Odtwarzanie
        results.put("3_Odtwarzanie", player.getStatus());

        player.pause(); // Pauza
        results.put("4_Pauza", player.getStatus());

        player.stop(); // Stop z poziomu pauzy
        results.put("5_Stop", player.getStatus());

        return results;
    }

    // Przykład 3: Support Ticket
    @GetMapping("/ticket")
    public Map<String, String> testTicketState() {
        Map<String, String> results = new LinkedHashMap<>();

        SupportTicket ticket = new SupportTicket("Brak ubezpieczenia w koszyku");
        results.put("1_Nowe_Zgloszenie", ticket.getStatus());

        ticket.resolve(); // Błąd: za szybko by rozwiązać
        results.put("2_Bledne_Rozwiazanie", ticket.getStatus());

        ticket.assign(); // Przypisanie agenta -> W REALIZACJI
        results.put("3_Przypisanie", ticket.getStatus());

        ticket.resolve(); // Zrobione -> ROZWIĄZANE
        results.put("4_Rozwiazanie", ticket.getStatus());

        ticket.close(); // Akceptacja klienta -> ZAMKNIĘTE
        results.put("5_Zamkniecie", ticket.getStatus());

        return results;
    }
}
// Koniec, Tydzień 7, Wzorzec State 1, 2, 3 (TEST)