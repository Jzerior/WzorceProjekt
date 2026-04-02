package lab.wzorce.projekt.utils.iterators.products;

import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.iterators.IterableCollection;
import lab.wzorce.projekt.utils.iterators.Iterator;

// Tydzień 5, Wzorzec Iterator 3
public class ProductCatalog implements IterableCollection<Product> {
    private final Product[] products;
    private int size = 0;

    public ProductCatalog(int capacity) {
        products = new Product[capacity];
    }

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size] = product;
            size++;
        }
    }

    @Override
    public Iterator<Product> createIterator() {
        return new ProductIterator(products, size);
    }
}