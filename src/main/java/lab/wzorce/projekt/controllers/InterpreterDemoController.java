package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.models.User;
import lab.wzorce.projekt.utils.interpreters.discount.*;
import lab.wzorce.projekt.utils.interpreters.permissions.*;
import lab.wzorce.projekt.utils.interpreters.search.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/interpreter")
public class InterpreterDemoController {

    @GetMapping("/search")
    public Map<String, Object> testSearchInterpreter() {
        Map<String, Object> results = new LinkedHashMap<>();

        // Tworzymy produkt testowy z użyciem Buildera
        Product product = new Product.Builder()
                .name("Wędka Karpiowa")
                .price(new BigDecimal("150.0"))
                .category("Wędkarstwo")
                .build();

        // Budujemy gramatykę zapytań: Kategoria == Wędkarstwo AND Cena <= 200
        ProductExpression isFishing = new CategoryExpression("Wędkarstwo");
        ProductExpression isCheap = new MaxPriceExpression(200.0);
        ProductExpression affordableFishingGear = new AndProductExpression(isFishing, isCheap);

        results.put("Produkt", product.getName());
        results.put("Czy wędkarstwo?", isFishing.interpret(product));
        results.put("Czy tanio (<= 200)?", isCheap.interpret(product));
        results.put("Czy tanio ORAZ wędkarstwo?", affordableFishingGear.interpret(product));

        return results;
    }

    @GetMapping("/permissions")
    public Map<String, Object> testPermissionsInterpreter() {
        Map<String, Object> results = new LinkedHashMap<>();

        User user = new User.Builder()
                .login("janek")
                .privilege("manager")
                .build();

        // Złożone zapytanie o uprawnienia: czy użytkownik jest adminem LUB managerem?
        PermissionExpression isAdmin = new RoleExpression("admin");
        PermissionExpression isManager = new RoleExpression("manager");
        PermissionExpression hasAccess = new OrPermissionExpression(isAdmin, isManager);

        results.put("Rola użytkownika", user.getPrivilege());
        results.put("Czy jest adminem?", isAdmin.interpret(user));
        results.put("Czy ma dostęp (admin LUB manager)?", hasAccess.interpret(user));

        return results;
    }

    @GetMapping("/discounts")
    public Map<String, Object> testDiscountsInterpreter() {
        Map<String, Object> results = new LinkedHashMap<>();

        Product p1 = new Product.Builder().name("Model T-34").category("Modele").price(new BigDecimal("200")).build();
        OrderItem item1 = new OrderItem();
        item1.setProduct(p1);
        item1.setQuantity(1);
        item1.setUnitPrice(p1.getPrice());

        Order order = new Order.Builder()
                .addItem(item1)
                .build();

        // Reguła rabatowa: Koszyk >= 150 PLN ORAZ Zawiera produkty z kategorii 'Modele'
        DiscountExpression over150 = new MinOrderValueExpression(150.0);
        DiscountExpression hasModels = new HasItemCategoryExpression("Modele");
        DiscountExpression validForDiscount = new AndDiscountExpression(over150, hasModels);

        results.put("Wartość koszyka", order.getTotalPrice());
        results.put("Czy koszyk powyżej 150?", over150.interpret(order));
        results.put("Czy koszyk zawiera 'Modele'?", hasModels.interpret(order));
        results.put("Czy przysługuje rabat (powyżej 150 AND Modele)?", validForDiscount.interpret(order));

        return results;
    }
}