package lab.wzorce.projekt.utils.factories;

import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;

public class OrderItemFactory {
    public static OrderItem createFromProduct(Product product, int quantity) {
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setUnitPrice(product.getPrice());
        return item;
    }
}