package lab.wzorce.projekt.utils.mediators.dashboard;

/**
 * Tydzień 5, Wzorzec Mediator 2
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public abstract class UIComponent {
    protected DashboardMediator mediator;
    public UIComponent(DashboardMediator mediator) { this.mediator = mediator; }
}

// Koniec, Tydzień 5, Wzorzec Mediator 2
