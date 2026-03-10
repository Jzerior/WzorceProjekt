package lab.wzorce.projekt.utils.factories;

import lab.wzorce.projekt.models.Product;
import java.math.BigDecimal;

public class ProductFactory {

    public static Product createModelKit(String name, double price, int stock) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(BigDecimal.valueOf(price));
        product.setStockQuantity(stock);
        product.setCategory("MODEL_KIT");
        return product;
    }

    public static Product createFishingAccessory(String name, double price, int stock) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(BigDecimal.valueOf(price));
        product.setStockQuantity(stock);
        product.setCategory("FISHING_ACCESSORY");
        return product;
    }

    public static Product createCustomProduct(String name, double price, int stock, String category) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(BigDecimal.valueOf(price));
        product.setStockQuantity(stock);
        product.setCategory(category);
        return product;
    }
}