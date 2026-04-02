package lab.wzorce.projekt.utils.iterators.categories;

import lab.wzorce.projekt.models.Product;
import lab.wzorce.projekt.utils.iterators.Iterator;

import java.util.List;

// Tydzień 5, Wzorzec Iterator 1
public class CategoryIterator implements Iterator<Product> {
    private final List<Product> items;
    private final String targetCategory;
    private int position = 0;

    public CategoryIterator(List<Product> items, String targetCategory) {
        this.items = items;
        this.targetCategory = targetCategory;
    }

    @Override
    public boolean hasNext() {
        while (position < items.size()) {
            Product current = items.get(position);
            if (targetCategory.equals("ALL") || current.getCategory().equalsIgnoreCase(targetCategory)) {
                return true;
            }
            position++;
        }
        return false;
    }

    @Override
    public Product next() {
        if (!hasNext()) return null;
        Product product = items.get(position);
        position++;
        return product;
    }
}