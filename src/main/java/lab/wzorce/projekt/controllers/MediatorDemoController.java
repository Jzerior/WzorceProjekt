package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.mediators.chat.*;
import lab.wzorce.projekt.utils.mediators.dashboard.*;
import lab.wzorce.projekt.utils.mediators.fulfillment.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tydzień 5, Wzorzec Mediator 1, 2, 3 (TEST)
 * Sprawdzenie działania.
 */

@RestController
@RequestMapping("/api/demo/mediator")
public class MediatorDemoController {

    @GetMapping("/chat")
    public String testChat() {
        SupportChatRoom room = new SupportChatRoom();
        ChatUser u1 = new Customer(room, "Janek");
        ChatUser a1 = new SupportAgent(room, "Agent Tomek");
        room.addUser(u1);
        room.addUser(a1);

        u1.send("Moje zamówienie nie dotarło!");
        a1.send("Sprawdzam status w systemie...");
        return "Czat wykonany. Sprawdź konsolę serwera.";
    }

    @GetMapping("/fulfillment")
    public String testFulfillment() {
        FulfillmentSystem system = new FulfillmentSystem();
        WarehouseDept w = new WarehouseDept(system);
        AccountingDept a = new AccountingDept(system);
        LogisticsDept l = new LogisticsDept(system);
        system.setDepartments(w, a, l);

        w.packageItems();
        return "Zamówienie zrealizowane. Sprawdź konsolę serwera.";
    }

    @GetMapping("/dashboard")
    public String testDashboard() {
        AdminDashboard dashboard = new AdminDashboard();
        DateFilter filter = new DateFilter(dashboard);
        SalesChart chart = new SalesChart(dashboard);
        ExportButton exportBtn = new ExportButton(dashboard);

        dashboard.setComponents(filter, chart, exportBtn);

        filter.selectDateRange();

        return "Zmieniono filtr daty. Sprawdź konsolę serwera, aby zobaczyć jak Mediator zaktualizował wykres i odblokował przycisk.";
    }
}

// Koniec, Tydzień 5, Wzorzec Mediator 1, 2, 3 (TEST)