package lab.wzorce.projekt.utils.mediators.dashboard;

/**
 * Tydzień 5, Wzorzec Mediator 2
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class ExportButton extends UIComponent {
    public ExportButton(DashboardMediator mediator) { super(mediator); }
    public void enable() { System.out.println("[Przycisk Eksportu] Aktywowany."); }
}

// Koniec, Tydzień 5, Wzorzec Mediator 2
