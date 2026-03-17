package lab.wzorce.projekt.utils.adapters.reports;

import lab.wzorce.projekt.utils.bridges.reports.ReportRenderer;

// Tydzień 2, Wzorzec Adapter 3
// Wzorzec projektowy Adapter integrujący zewnętrzny generator
// ExternalJsonGenerator z systemem raportowym poprzez implementację interfejsu ReportRenderer.
public class JsonReportAdapter implements ReportRenderer {
    private ExternalJsonGenerator jsonGenerator;

    public JsonReportAdapter(ExternalJsonGenerator jsonGenerator) {
        this.jsonGenerator = jsonGenerator;
    }

    @Override
    public String render(String title, String data) {
        return "Adapter JSON: " + jsonGenerator.createJsonNode(title, data);
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter 3.