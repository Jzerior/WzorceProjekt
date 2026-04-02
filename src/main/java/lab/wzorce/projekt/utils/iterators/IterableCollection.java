package lab.wzorce.projekt.utils.iterators;

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}