package lab.wzorce.projekt.utils.mediators.dashboard;

/**
 * Tydzień 5, Wzorzec Mediator 2
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class AdminDashboard implements DashboardMediator {
    private DateFilter filter;
    private SalesChart chart;
    private ExportButton exportBtn;

    public void setComponents(DateFilter f, SalesChart c, ExportButton e) {
        this.filter = f; this.chart = c; this.exportBtn = e;
    }

    @Override
    public void componentChanged(UIComponent component) {
        if (component == filter) {
            chart.refresh();
            exportBtn.enable();
        }
    }
}

// Koniec, Tydzień 5, Wzorzec Mediator 2
