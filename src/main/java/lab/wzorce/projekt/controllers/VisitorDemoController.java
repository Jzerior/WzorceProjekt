package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.visitors.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/visitor")
public class VisitorDemoController {

    @GetMapping("/test")
    public Map<String, Object> testVisitors() {
        Map<String, Object> results = new LinkedHashMap<>();

        List<VisitableItem> cart = Arrays.asList(
                new ModelKitItem("PZL P.11c 1:72", 120.0),
                new FishingRodItem("Wędka Karpiowa Pro", 350.0, 3.6),
                new MagazineItem("Wędkarz Polski", 15.0, 10)
        );

        TaxVisitor taxVisitor = new TaxVisitor();
        for (VisitableItem item : cart) {
            item.accept(taxVisitor);
        }
        results.put("1_Laczny_Podatek_VAT", taxVisitor.getTotalTax() + " PLN");

        DiscountVisitor discountVisitor = new DiscountVisitor();
        for (VisitableItem item : cart) {
            item.accept(discountVisitor);
        }
        results.put("2_Laczna_Znizka", discountVisitor.getTotalDiscount() + " PLN");

        HtmlExportVisitor htmlVisitor = new HtmlExportVisitor();
        for (VisitableItem item : cart) {
            item.accept(htmlVisitor);
        }
        results.put("3_Wygenerowany_HTML", htmlVisitor.getHtml());

        return results;
    }
}