package lab.wzorce.projekt.utils.visitors;

public class ModelKitItem implements VisitableItem {
    private final String name;
    private final double price;

    public ModelKitItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}