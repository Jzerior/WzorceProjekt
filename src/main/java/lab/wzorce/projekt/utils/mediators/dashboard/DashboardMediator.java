package lab.wzorce.projekt.utils.mediators.dashboard;

/**
 * Tydzień 5, Wzorzec Mediator 2
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public interface DashboardMediator {
    void componentChanged(UIComponent component);
}

// Koniec, Tydzień 5, Wzorzec Mediator 2
