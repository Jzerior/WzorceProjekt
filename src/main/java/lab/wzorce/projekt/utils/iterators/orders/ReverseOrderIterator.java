package lab.wzorce.projekt.utils.iterators.orders;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.utils.iterators.Iterator;

import java.util.List;

// Tydzień 5, Wzorzec Iterator 2
public class ReverseOrderIterator implements Iterator<Order> {
    private final List<Order> orders;
    private int position;

    public ReverseOrderIterator(List<Order> orders) {
        this.orders = orders;
        this.position = orders.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Order next() {
        if (!hasNext()) return null;
        Order order = orders.get(position);
        position--;
        return order;
    }
}