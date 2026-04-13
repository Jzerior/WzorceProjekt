package lab.wzorce.projekt.utils.visitors;

public interface Visitor {
    void visit(ModelKitItem modelKit);
    void visit(FishingRodItem fishingRod);
    void visit(MagazineItem magazine);
}