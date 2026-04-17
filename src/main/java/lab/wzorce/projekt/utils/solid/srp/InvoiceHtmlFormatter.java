package lab.wzorce.projekt.utils.solid.srp;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa odpowiada WYŁĄCZNIE za prezentację danych (formatowanie do HTML).
// Zmiana układu strony, dodanie znaczników CSS lub tabel wpłynie tylko na ten plik.
public class InvoiceHtmlFormatter {
    private final InvoiceCalculator calculator;

    public InvoiceHtmlFormatter(InvoiceCalculator calculator) {
        this.calculator = calculator;
    }

    public String format(Invoice invoice) {
        StringBuilder html = new StringBuilder();
        html.append("<div class='invoice'>\n");
        html.append("  <h2>Faktura dla: ").append(invoice.getCustomerName()).append("</h2>\n");
        html.append("  <ul>\n");

        for (InvoiceItem item : invoice.getItems()) {
            html.append("    <li>").append(item.getName())
                    .append(" (").append(item.getQuantity()).append(" szt. x ")
                    .append(item.getPrice()).append(" PLN)</li>\n");
        }

        html.append("  </ul>\n");
        html.append("  <p>Kwota Netto: <b>").append(calculator.calculateTotalNet(invoice)).append(" PLN</b></p>\n");
        html.append("  <p>Podatek VAT: <b>").append(calculator.calculateTaxAmount(invoice)).append(" PLN</b></p>\n");
        html.append("  <h3>Do zapłaty Brutto: ").append(calculator.calculateTotalGross(invoice)).append(" PLN</h3>\n");
        html.append("</div>");

        return html.toString();
    }
}
// Koniec, Tydzień 7, Zasada SRP