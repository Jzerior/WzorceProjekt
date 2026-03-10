package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.models.User;
import lab.wzorce.projekt.utils.factories.OrderItemFactory;
import lab.wzorce.projekt.utils.factories.ProductFactory;
import lab.wzorce.projekt.utils.factories.UserFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/demo/factory")
public class FactoryDemoController {

    @GetMapping("/products")
    public Map<String, Product> testProductFactory() {
        return Map.of(
                "modelKit", ProductFactory.createModelKit("PZL P.11c", 89.99, 15),
                "fishingAccessory", ProductFactory.createFishingAccessory("Wędka spinningowa", 250.0, 10),
                "custom", ProductFactory.createCustomProduct("Klej modelarski", 15.0, 50, "TOOLS")
        );
    }

    @GetMapping("/users")
    public Map<String, User> testUserFactory() {
        return Map.of(
                "admin", UserFactory.createAdmin("boss", "boss@hobby-sklep.pl", "admin123"),
                "customer", UserFactory.createCustomer("hobbyist88", "klient@poczta.pl", "user123")
        );
    }

    @GetMapping("/order-item")
    public OrderItem testOrderItemFactory() {
        Product p = ProductFactory.createModelKit("Czołg T-34", 120.0, 5);
        return OrderItemFactory.createFromProduct(p, 1);
    }

}