package lab.wzorce.projekt.utils.visitors;

// Tydzień 6, Wzorzec Iterator 2
public class FishingRodItem implements VisitableItem {
    private final String name;
    private final double price;
    private final double lengthInMeters;

    public FishingRodItem(String name, double price, double lengthInMeters) {
        this.name = name;
        this.price = price;
        this.lengthInMeters = lengthInMeters;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getLengthInMeters() { return lengthInMeters; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
//Koniec Tydzień 6, Wzorzec Iterator 2