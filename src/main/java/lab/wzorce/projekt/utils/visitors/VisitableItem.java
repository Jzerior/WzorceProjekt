package lab.wzorce.projekt.utils.visitors;

public interface VisitableItem {
    void accept(Visitor visitor);
}