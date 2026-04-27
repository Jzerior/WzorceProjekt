package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.solid.dip.OrderFulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dip-demo")
public class DipDemoController {

    private final OrderFulfillmentService orderFulfillmentService;

    @Autowired
    public DipDemoController(OrderFulfillmentService orderFulfillmentService) {
        this.orderFulfillmentService = orderFulfillmentService;
    }

    @PostMapping("/fulfill")
    public ResponseEntity<String> fulfillOrder(
            @RequestParam String productId,
            @RequestParam double amount) {

        orderFulfillmentService.fulfillOrder(productId, amount);

        return ResponseEntity.ok("Akcja w DipDemoController wykonana pomyślnie dla produktu: " + productId);
    }
}