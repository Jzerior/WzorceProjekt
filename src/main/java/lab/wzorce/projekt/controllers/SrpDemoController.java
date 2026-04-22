package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.solid.srp.delivery.Delivery;
import lab.wzorce.projekt.utils.solid.srp.delivery.DeliveryCostCalculator;
import lab.wzorce.projekt.utils.solid.srp.delivery.DeliveryLabelFormatter;
import lab.wzorce.projekt.utils.solid.srp.delivery.DeliveryRepository;
import lab.wzorce.projekt.utils.solid.srp.invoice.*;
import lab.wzorce.projekt.utils.solid.srp.salary.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

// Tydzień 7, Zasada SRP - Kontroler testowy
@RestController
@RequestMapping("/api/demo/srp")
public class SrpDemoController {

    @GetMapping("/invoice")
    public Map<String, String> testSrpInvoiceSystem() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Użycie struktury Danych (Invoice oraz InvoiceItem)
        Invoice invoice = new Invoice("Jan Kowalski - Sklep Wędkarski");
        invoice.addItem(new InvoiceItem("Wędka Karpiowa", 250.0, 2));
        invoice.addItem(new InvoiceItem("Kołowrotek", 150.0, 1));
        invoice.addItem(new InvoiceItem("Żyłka fluocarbon", 30.0, 3));

        // 2. Użycie logiki obliczeniowej (InvoiceCalculator)
        InvoiceCalculator calculator = new InvoiceCalculator();
        results.put("1_Logika_Biznesowa", "Suma brutto wynosi: " + calculator.calculateTotalGross(invoice) + " PLN");

        // 3. Użycie logiki prezentacji (InvoiceHtmlFormatter)
        InvoiceHtmlFormatter formatter = new InvoiceHtmlFormatter(calculator);
        results.put("2_Wygenerowany_HTML", "\n" + formatter.format(invoice));

        // 4. Użycie logiki utrwalania danych (InvoiceRepository)
        InvoiceRepository repository = new InvoiceRepository();
        results.put("3_Warstwa_Zapisu", repository.saveToDatabase(invoice));

        return results;
    }

    @GetMapping("/salary")
    public Map<String, String> testSrpSalarySystem() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Użycie struktury Danych (Employee)
        Employee employee = new Employee("Anna Nowak", 8500.0);

        // 2. Użycie logiki obliczeniowej (SalaryCalculator)
        SalaryCalculator calculator = new SalaryCalculator();
        results.put("1_Logika_Biznesowa", "Pensja netto wynosi: " + calculator.calculateNetSalary(employee) + " PLN");

        // 3. Użycie logiki prezentacji (SalaryReportFormatter)
        SalaryReportFormatter formatter = new SalaryReportFormatter(calculator);
        results.put("2_Wygenerowany_Raport", "\n" + formatter.format(employee));

        // 4. Użycie logiki utrwalania danych (SalaryRepository)
        SalaryRepository repository = new SalaryRepository();
        results.put("3_Warstwa_Zapisu", repository.saveReport(employee));

        return results;
    }

    @GetMapping("/delivery")
    public Map<String, String> testSrpDeliverySystem() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Użycie struktury Danych (Delivery)
        Delivery delivery = new Delivery("Piotr Wędkarz", "ul. Karpiowa 10, Lublin", 12.5, 45.0);

        // 2. Użycie logiki obliczeniowej (DeliveryCostCalculator)
        DeliveryCostCalculator calculator = new DeliveryCostCalculator();
        results.put("1_Logika_Biznesowa", "Całkowity koszt dostawy wynosi: " + calculator.calculateTotalCost(delivery) + " PLN");

        // 3. Użycie logiki prezentacji (DeliveryLabelFormatter)
        DeliveryLabelFormatter formatter = new DeliveryLabelFormatter(calculator);
        results.put("2_Wygenerowana_Etykieta", "\n" + formatter.formatLabel(delivery));

        // 4. Użycie logiki utrwalania danych (DeliveryRepository)
        DeliveryRepository repository = new DeliveryRepository();
        results.put("3_Warstwa_Zapisu", repository.saveDeliveryOrder(delivery));

        return results;
    }
}
// Koniec, Tydzień 7, Zasada SRP