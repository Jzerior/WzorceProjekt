package lab.wzorce.projekt.utils.factories;

import lab.wzorce.projekt.models.Product;
import java.math.BigDecimal;

// Tydzień 1, Wzorzec Fabryka 2
// Wzorzec projektowy Fabryka zaimplementowany w formie statycznych metod fabrykujących.
// Centralizuje i upraszcza proces tworzenia predefiniowanych produktów , ukrywając przed klientem logikę przypisywania kategorii i konwersji cen.
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
// Koniec, Tydzień 1, Wzorzec Fabryka 2.