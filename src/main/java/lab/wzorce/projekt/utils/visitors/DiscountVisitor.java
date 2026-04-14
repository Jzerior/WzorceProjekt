package lab.wzorce.projekt.utils.visitors;

// Tydzień 6, Wzorzec Iterator 1
public class DiscountVisitor implements Visitor {
    private double totalDiscount = 0;

    @Override
    public void visit(ModelKitItem modelKit) {
        totalDiscount += modelKit.getPrice() * 0.10;
    }

    @Override
    public void visit(FishingRodItem fishingRod) {
        totalDiscount += fishingRod.getPrice() * 0.15;
    }

    @Override
    public void visit(MagazineItem magazine) {
        totalDiscount += 0;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }
}
//Koniec Tydzień 6, Wzorzec Iterator 1