package lab.wzorce.projekt.utils.mediators.dashboard;

/**
 * Tydzień 5, Wzorzec Mediator 2
 * Zmniejszenie zależności między wieloma komunikującymi się obiektami
 * poprzez wprowadzenie centralnego punktu kontroli (Mediatora).
 */

public class DateFilter extends UIComponent {
    public DateFilter(DashboardMediator mediator) { super(mediator); }
    public void selectDateRange() {
        System.out.println("[Filtr Daty] Zmieniono zakres na: Ostatnie 30 dni.");
        mediator.componentChanged(this);
    }
}

// Koniec, Tydzień 5, Wzorzec Mediator 2
