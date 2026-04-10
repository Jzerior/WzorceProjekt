package lab.wzorce.projekt.utils.states.ticket;

// Tydzień 7, Wzorzec State 3
public class ClosedState implements TicketState {
    @Override
    public void assign(SupportTicket context) {
        System.out.println("BŁĄD: Zgłoszenie zamknięte. Jeśli masz nowy problem, otwórz nowe zgłoszenie.");
    }

    @Override
    public void resolve(SupportTicket context) {
        System.out.println("BŁĄD: Zgłoszenie jest już zamknięte.");
    }

    @Override
    public void close(SupportTicket context) {
        System.out.println("BŁĄD: Zgłoszenie jest już permanentnie zamknięte.");
    }

    @Override
    public String getStatus() {
        return "ZAMKNIĘTE";
    }
}
// Koniec, Tydzień 7, Wzorzec State 3