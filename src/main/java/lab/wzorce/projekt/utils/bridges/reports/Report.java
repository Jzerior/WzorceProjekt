// Tydzień 3, Wzorzec Bridge 3
package lab.wzorce.projekt.utils.bridges.reports;

// Abstrakcja
public abstract class Report {
    protected ReportRenderer renderer; // Most (Bridge)

    public Report(ReportRenderer renderer) {
        this.renderer = renderer;
    }

    public abstract String generate();
}
// Koniec tydzień 3, Wzorzec Bridge 3