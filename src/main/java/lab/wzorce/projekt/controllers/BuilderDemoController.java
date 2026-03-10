package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/demo/builder")
public class BuilderDemoController {

    @GetMapping("/product")
    public Product testProductBuilder() {
        return new Product.Builder()
                .name("Laptop")
                .description("Laptop do gier")
                .price(new BigDecimal("4500.00"))
                .stockQuantity(10)
                .category("Elektronika")
                .build();
    }

    @GetMapping("/user")
    public User testUserBuilder() {
        return new User.Builder()
                .login("admin_user")
                .email("admin@sklep.pl")
                .password("tajnehaslo123")
                .privilege("admin")
                .build();
    }

    @GetMapping("/order")
    public Order testOrderBuilder() {
        User user = new User.Builder()
                .login("jan_kowalski")
                .email("jan@wp.pl")
                .password("haslo123")
                .build();

        Product product = new Product.Builder()
                .name("Myszka")
                .price(new BigDecimal("150.00"))
                .build();

        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(2);
        item.setUnitPrice(product.getPrice());

        return new Order.Builder()
                .user(user)
                .shippingAddress("Lublin")
                .status("PENDING")
                .addItem(item)
                .build();
    }
}