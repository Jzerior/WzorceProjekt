package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.templates.importer.*;
import lab.wzorce.projekt.utils.templates.newsletter.*;
import lab.wzorce.projekt.utils.templates.order.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Tydzień 6, Wzorzec Template 1, 2, 3 (TEST)
 * Sprawdzenie działania.
 */

@RestController
@RequestMapping("/api/demo/template")
public class TemplateDemoController {

    @GetMapping("/test")
    public Map<String, String> testTemplateMethods() {
        Map<String, String> results = new LinkedHashMap<>();

        // 1. Zamówienia (Template Method)
        OrderProcessorTemplate standard = new StandardOrderProcessor();
        OrderProcessorTemplate preorder = new PreOrderProcessor();
        results.put("1_Zamowienie_Standard", "\n" + standard.processOrder());
        results.put("2_Zamowienie_Preorder", "\n" + preorder.processOrder());

        // 2. Import (Template Method)
        DataImporterTemplate csvImport = new CsvImporter();
        DataImporterTemplate xmlImport = new XmlImporter();
        results.put("3_Import_CSV", "\n" + csvImport.runImport());
        results.put("4_Import_XML", "\n" + xmlImport.runImport());

        // 3. Newsletter (Template Method)
        NewsletterTemplate promoMail = new PromoNewsletter();
        NewsletterTemplate systemMail = new SystemUpdateNewsletter();
        results.put("5_Newsletter_Promo", "\n" + promoMail.generateAndSend());
        results.put("6_Newsletter_System", "\n" + systemMail.generateAndSend());

        return results;
    }
}

// Koniec, Tydzień 6, Wzorzec Template 1, 2, 3 (TEST)