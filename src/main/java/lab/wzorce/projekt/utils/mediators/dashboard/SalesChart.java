package lab.wzorce.projekt.utils.mediators.dashboard;

/**
 * Tydzień 5, Wzorzec Mediator 2
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class SalesChart extends UIComponent {
    public SalesChart(DashboardMediator mediator) { super(mediator); }
    public void refresh() { System.out.println("[Wykres] Odświeżanie danych..."); }
}

// Koniec, Tydzień 5, Wzorzec Mediator 2
