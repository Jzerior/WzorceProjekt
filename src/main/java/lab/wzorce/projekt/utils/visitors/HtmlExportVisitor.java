package lab.wzorce.projekt.utils.visitors;

// Tydzień 6, Wzorzec Iterator 3
public class HtmlExportVisitor implements Visitor {
    private final StringBuilder htmlBuilder = new StringBuilder();

    @Override
    public void visit(ModelKitItem modelKit) {
        htmlBuilder.append("<div class='product model-kit'>\n")
                .append("  <h4>Model do sklejania: ").append(modelKit.getName()).append("</h4>\n")
                .append("  <p>Cena: ").append(modelKit.getPrice()).append(" PLN</p>\n")
                .append("</div>\n");
    }

    @Override
    public void visit(FishingRodItem fishingRod) {
        htmlBuilder.append("<div class='product fishing-rod'>\n")
                .append("  <h4>Wędka: ").append(fishingRod.getName()).append("</h4>\n")
                .append("  <p>Długość: ").append(fishingRod.getLengthInMeters()).append(" m</p>\n")
                .append("  <p>Cena: ").append(fishingRod.getPrice()).append(" PLN</p>\n")
                .append("</div>\n");
    }

    @Override
    public void visit(MagazineItem magazine) {
        htmlBuilder.append("<div class='product magazine'>\n")
                .append("  <h4>Magazyn: ").append(magazine.getTitle()).append(" (Nr ").append(magazine.getIssueNumber()).append(")</h4>\n")
                .append("  <p>Cena: ").append(magazine.getPrice()).append(" PLN</p>\n")
                .append("</div>\n");
    }

    public String getHtml() {
        return htmlBuilder.toString();
    }
}
//Koniec Tydzień 6, Wzorzec Iterator 3