package lab.wzorce.projekt.utils.iterators.orders;

import lab.wzorce.projekt.models.Order;
import lab.wzorce.projekt.utils.iterators.IterableCollection;
import lab.wzorce.projekt.utils.iterators.Iterator;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Iterator 2
public class OrderHistory implements IterableCollection<Order> {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public Iterator<Order> createIterator() {
        return new ReverseOrderIterator(orders);
    }
}