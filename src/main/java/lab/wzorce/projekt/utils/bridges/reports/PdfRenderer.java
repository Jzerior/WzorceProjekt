// Tydzień 3, Wzorzec Bridge 3
package lab.wzorce.projekt.utils.bridges.reports;

// Konkretny Implementator A
public class PdfRenderer implements ReportRenderer {
    @Override
    public String render(String title, String data) {
        return "Generowanie pliku PDF... \n[NAGŁÓWEK PDF]: " + title + "\n[TREŚĆ PDF]: " + data;
    }
}
// Koniec tydzień 3, Wzorzec Bridge 3