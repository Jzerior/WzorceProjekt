package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.iterators.Iterator;
import lab.wzorce.projekt.utils.iterators.categories.Inventory;
import lab.wzorce.projekt.utils.iterators.orders.OrderHistory;
import lab.wzorce.projekt.utils.iterators.products.ProductCatalog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/demo/iterator")
public class IteratorDemoController {

    @GetMapping("/test")
    public Map<String, Object> testIteratorPattern() {
        Map<String, Object> results = new LinkedHashMap<>();

        ProductCatalog catalog = new ProductCatalog(10);
        catalog.addProduct(new Product.Builder().name("Laptop").category("Elektronika").build());
        catalog.addProduct(new Product.Builder().name("Myszka").category("Elektronika").build());

        List<String> catalogList = new ArrayList<>();
        Iterator<Product> catalogIterator = catalog.createIterator();
        while (catalogIterator.hasNext()) {
            catalogList.add(catalogIterator.next().getName());
        }
        results.put("1_Katalog_Produktow", catalogList);

        OrderHistory history = new OrderHistory();
        Order o1 = new Order(); o1.setId(1L); o1.setTotalPrice(new BigDecimal("100"));
        Order o2 = new Order(); o2.setId(2L); o2.setTotalPrice(new BigDecimal("200"));
        Order o3 = new Order(); o3.setId(3L); o3.setTotalPrice(new BigDecimal("300"));
        history.addOrder(o1);
        history.addOrder(o2);
        history.addOrder(o3);

        List<String> historyList = new ArrayList<>();
        Iterator<Order> historyIterator = history.createIterator();
        while (historyIterator.hasNext()) {
            Order order = historyIterator.next();
            historyList.add("ZAM-" + order.getId() + " (" + order.getTotalPrice() + " PLN)");
        }
        results.put("2_Historia_Zamowien_Odwrócona", historyList);

        Inventory inventory = new Inventory();
        inventory.addItem(new Product.Builder().name("Wędka").category("Wędkarstwo").build());
        inventory.addItem(new Product.Builder().name("Piłka").category("Sport").build());
        inventory.addItem(new Product.Builder().name("Spławik").category("Wędkarstwo").build());

        List<String> fishingList = new ArrayList<>();
        Iterator<Product> fishingIterator = inventory.createIterator("Wędkarstwo");
        while (fishingIterator.hasNext()) {
            fishingList.add(fishingIterator.next().getName());
        }
        results.put("3_Inwentarz_Filtrowany_Wedkarstwo", fishingList);

        return results;
    }
}