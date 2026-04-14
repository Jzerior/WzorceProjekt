package lab.wzorce.projekt.utils.visitors;

public class TaxVisitor implements Visitor {
    private double totalTax = 0;

    @Override
    public void visit(ModelKitItem modelKit) {
        totalTax += modelKit.getPrice() * 0.23;
    }

    @Override
    public void visit(FishingRodItem fishingRod) {
        totalTax += fishingRod.getPrice() * 0.23;
    }

    @Override
    public void visit(MagazineItem magazine) {
        totalTax += magazine.getPrice() * 0.08;
    }

    public double getTotalTax() {
        return totalTax;
    }
}