package lab.wzorce.projekt.utils.iterators.categories;

import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.iterators.IterableCollection;
import lab.wzorce.projekt.utils.iterators.Iterator;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Iterator 1
public class Inventory implements IterableCollection<Product> {
    private final List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    @Override
    public Iterator<Product> createIterator() {
        return new CategoryIterator(items, "ALL");
    }

    public Iterator<Product> createIterator(String category) {
        return new CategoryIterator(items, category);
    }
}