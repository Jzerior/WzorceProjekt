package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.adapters.messages.FaxAdapter;
import lab.wzorce.projekt.utils.adapters.messages.LegacyFaxSystem;
import lab.wzorce.projekt.utils.adapters.payments.AllegroPayAdapter;
import lab.wzorce.projekt.utils.adapters.payments.ExternalAllegroPayService;
import lab.wzorce.projekt.utils.adapters.reports.ExternalJsonGenerator;
import lab.wzorce.projekt.utils.adapters.reports.JsonReportAdapter;
import lab.wzorce.projekt.utils.bridges.messages.MessageSender;
import lab.wzorce.projekt.utils.bridges.payments.PaymentProvider;
import lab.wzorce.projekt.utils.bridges.reports.Report;
import lab.wzorce.projekt.utils.bridges.reports.ReportRenderer;
import lab.wzorce.projekt.utils.bridges.reports.SalesReport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/adapter")
public class AdapterDemoController {

    @GetMapping("/test")
    public Map<String, String> testAdapters() {
        Map<String, String> results = new LinkedHashMap<>();

        PaymentProvider allegropay = new AllegroPayAdapter(new ExternalAllegroPayService());
        results.put("allegropay_payment", allegropay.processPayment(250.0));

        MessageSender fax = new FaxAdapter(new LegacyFaxSystem());
        results.put("fax_sender", fax.sendMessage("Zamówienie nr 500"));

        ReportRenderer jsonAdapter = new JsonReportAdapter(new ExternalJsonGenerator());
        Report salesReport = new SalesReport(jsonAdapter);
        results.put("report_json", salesReport.generate());

        return results;
    }
}