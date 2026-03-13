// Tydzień 3, Wzorzec Bridge - testy
package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.bridges.messages.*;
import lab.wzorce.projekt.utils.bridges.payments.*;
import lab.wzorce.projekt.utils.bridges.reports.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/bridge")
public class BridgeDemoController {

    @GetMapping("/notifications")
    public Map<String, String> testNotifications() {
        Map<String, String> responses = new LinkedHashMap<>();

        // 1. Inicjalizacja mechanizmów wysyłki (Implementatory)
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SmsSender();

        // 2. Tworzenie pełnego przekroju kombinacji (Abstrakcja + Implementator)
        Notification orderViaEmail = new OrderShippedNotification(emailSender, "ZAM-99123");
        Notification orderViaSms = new OrderShippedNotification(smsSender, "ZAM-99123");

        Notification reminderViaEmail = new PaymentReminderNotification(emailSender, 450.00);
        Notification reminderViaSms = new PaymentReminderNotification(smsSender, 450.00);

        // 3. Wyniki
        responses.put("1_order_email", orderViaEmail.send());
        responses.put("2_order_sms", orderViaSms.send());
        responses.put("3_reminder_email", reminderViaEmail.send());
        responses.put("4_reminder_sms", reminderViaSms.send());

        return responses;
    }

    @GetMapping("/payments")
    public Map<String, String> testPayments() {
        Map<String, String> responses = new LinkedHashMap<>();

        // 1. Bramki płatnicze
        PaymentProvider blik = new BlikProvider();
        PaymentProvider paypal = new PayPalProvider();

        // 2. Kombinacje rodzajów płatności i bramek
        Payment standardBlik = new StandardPayment(blik);
        Payment standardPayPal = new StandardPayment(paypal);

        Payment installmentBlik = new InstallmentPayment(blik, 3);
        Payment installmentPayPal = new InstallmentPayment(paypal, 12);

        // 3. Wykonanie transakcji na różne sposoby
        responses.put("1_standard_blik", standardBlik.execute(150.00));
        responses.put("2_standard_paypal", standardPayPal.execute(150.00));
        responses.put("3_raty_blik", installmentBlik.execute(3000.00));
        responses.put("4_raty_paypal", installmentPayPal.execute(4500.00));

        return responses;
    }

    @GetMapping("/reports")
    public Map<String, String> testReports() {
        Map<String, String> responses = new LinkedHashMap<>();

        // 1. Formaty wyjściowe
        ReportRenderer pdfRenderer = new PdfRenderer();
        ReportRenderer csvRenderer = new CsvRenderer();

        // 2. Różne raporty w różnych formatach
        Report salesPdf = new SalesReport(pdfRenderer);
        Report salesCsv = new SalesReport(csvRenderer);

        Report inventoryPdf = new InventoryReport(pdfRenderer);
        Report inventoryCsv = new InventoryReport(csvRenderer);

        // 3. Generowanie
        responses.put("1_sales_pdf", salesPdf.generate());
        responses.put("2_sales_csv", salesCsv.generate());
        responses.put("3_inventory_pdf", inventoryPdf.generate());
        responses.put("4_inventory_csv", inventoryCsv.generate());

        return responses;
    }
}
// Koniec tydzień 3, Wzorzec Bridge - testy