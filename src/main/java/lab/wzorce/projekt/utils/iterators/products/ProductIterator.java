package lab.wzorce.projekt.utils.iterators.products;

import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.iterators.Iterator;

// Tydzień 5, Wzorzec Iterator 3
public class ProductIterator implements Iterator<Product> {
    private final Product[] products;
    private final int size;
    private int position = 0;

    public ProductIterator(Product[] products, int size) {
        this.products = products;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public Product next() {
        if (!hasNext()) return null;
        Product product = products[position];
        position++;
        return product;
    }
}