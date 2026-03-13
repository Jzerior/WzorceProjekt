// Tydzień 3, Wzorzec Bridge 3
package lab.wzorce.projekt.utils.bridges.reports;

// Uszczegółowiona Abstrakcja A
public class SalesReport extends Report {
    public SalesReport(ReportRenderer renderer) {
        super(renderer);
    }

    @Override
    public String generate() {
        String title = "Miesieczny Raport Sprzedazy";
        String data = "Zysk: 15000PLN Zamowienia: 120 Zwroty: 5";
        return renderer.render(title, data);
    }
}
// Koniec tydzień 3, Wzorzec Bridge 3