package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.utils.bridges.messages.EmailSender;
import lab.wzorce.projekt.utils.bridges.messages.MessageSender;
import lab.wzorce.projekt.utils.bridges.payments.*;
import lab.wzorce.projekt.utils.facades.OrderFacade;
import lab.wzorce.projekt.utils.facades.ReportFacade;
import lab.wzorce.projekt.utils.facades.SystemFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facade")
public class FacadeDemoController {

    @GetMapping("/test")
    public String testFacades() {
        StringBuilder result = new StringBuilder();

        MessageSender emailSender = new EmailSender();
        PaymentProvider blik = new BlikProvider();

        OrderFacade orderFacade = new OrderFacade(blik,emailSender);
        Order order = new Order();
        order.setId(101L);

        orderFacade.placeOrder(order, 2);
        result.append("1. OrderFacade: Przetworzono zamówienie nr 101.\n");

        ReportFacade reportFacade = new ReportFacade();
        reportFacade.generateStandardMonthlyReports();
        result.append("2. ReportFacade: Wygenerowano raporty sprzedaży (PDF) i magazynowe (CSV).\n");

        SystemFacade systemFacade = new SystemFacade();
        String summary = systemFacade.getSystemStatusSummary();
        result.append("3. SystemFacade: Status systemu -> ").append(summary);

        return result.toString();
    }
}