package lab.wzorce.projekt.utils.facades;

import lab.wzorce.projekt.utils.bridges.reports.*;

// Tydzień 4, Wzorzec Facade 2
//Wzorzec Facade pozwala na uproszczenie procesu generowania raportów, poprzez udostępnienie jednej funkcji do ich generowania
public class ReportFacade {
    public void generateStandardMonthlyReports() {

        Report salesReport = new SalesReport(new PdfRenderer());
        salesReport.generate();

        Report inventoryReport = new InventoryReport(new CsvRenderer());
        inventoryReport.generate();
    }
}
//Koniec Tydzień 4, Wzorzec Facade 2
