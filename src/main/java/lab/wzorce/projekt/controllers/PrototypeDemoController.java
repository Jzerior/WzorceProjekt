package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.prototypes.DiscountCoupon;
import lab.wzorce.projekt.utils.prototypes.AdCampaign;
import lab.wzorce.projekt.utils.prototypes.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/prototype")
public class PrototypeDemoController {

    @GetMapping
    public String testPrototypes() {
        StringBuilder response = new StringBuilder();

        Product baseProduct = new Product("Spławik", 15.0, "Wędkarstwo");
        Product clonedProduct = baseProduct.clone();
        clonedProduct.setName("Spławik Ultra Light");
        clonedProduct.setPrice(19.0);

        response.append("Baza: ").append(baseProduct.toString()).append("<br>");
        response.append("Klon: ").append(clonedProduct.toString()).append("<br><br>");

        DiscountCoupon baseCoupon = new DiscountCoupon("WINTER2026", 15.0, true);
        DiscountCoupon userCoupon = baseCoupon.clone();
        userCoupon.setCode("WINTER2026-USER123");

        response.append("Kupon baza: ").append(baseCoupon.toString()).append("<br>");
        response.append("Kupon klon: ").append(userCoupon.toString()).append("<br><br>");

        AdCampaign baseCampaign = new AdCampaign("Black Friday 2025", "Klienci powracający", 15000.0, "Social Media");
        AdCampaign nextYearCampaign = baseCampaign.clone();

        nextYearCampaign.setCampaignName("Black Friday 2026");
        nextYearCampaign.setBudget(18000.0);

        response.append("Kampania baza: ").append(baseCampaign.toString()).append("<br>");
        response.append("Kampania klon: ").append(nextYearCampaign.toString());

        return response.toString();
    }
}