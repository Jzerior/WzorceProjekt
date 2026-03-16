package lab.wzorce.projekt.utils.factories;

import lab.wzorce.projekt.models.OrderItem;
import lab.wzorce.projekt.models.Product;

// Tydzień 1, Wzorzec Fabryka 3
// Wzorzec projektowy Fabryka zaimplementowany w formie statycznej metody fabrykującej.
// Upraszcza tworzenie pozycji zamówienia na podstawie obiektu Product, automatycznie pobierając z niego aktualną cenę jednostkową, co zapobiega błędom niespójności danych.
public class OrderItemFactory {
    public static OrderItem createFromProduct(Product product, int quantity) {
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        item.setUnitPrice(product.getPrice());
        return item;
    }
}
// Koniec, Tydzień 1, Wzorzec Fabryka 3.