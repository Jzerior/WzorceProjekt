// Tydzień 3, Wzorzec Bridge 3
package lab.wzorce.projekt.utils.bridges.reports;

// Konkretny Implementator B
public class CsvRenderer implements ReportRenderer {
    @Override
    public String render(String title, String data) {
        // Symulacja prostego formatowania na wartości oddzielone przecinkami
        String formattedData = data.replace(" ", ",");
        return "title,data\n" + title + "," + formattedData;
    }
}
// Koniec tydzień 3, Wzorzec Bridge 3