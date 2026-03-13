// Tydzień 3, Wzorzec Bridge 3
package lab.wzorce.projekt.utils.bridges.reports;

// Uszczegółowiona Abstrakcja B
public class InventoryReport extends Report {
    public InventoryReport(ReportRenderer renderer) {
        super(renderer);
    }

    @Override
    public String generate() {
        String title = "Raport Stanu Magazynowego";
        String data = "Brakujace_produkty: 3 W_magazynie: 1540";
        return renderer.render(title, data);
    }
}
// Koniec tydzień 3, Wzorzec Bridge 3