package lab.wzorce.projekt.utils.states.ticket;

// Tydzień 7, Wzorzec State 3
public class ResolvedState implements TicketState {
    @Override
    public void assign(SupportTicket context) {
        System.out.println("BŁĄD: Zgłoszenie jest już rozwiązane.");
    }

    @Override
    public void resolve(SupportTicket context) {
        System.out.println("BŁĄD: Zgłoszenie zostało już rozwiązane.");
    }

    @Override
    public void close(SupportTicket context) {
        System.out.println("Klient potwierdził rozwiązanie. Zgłoszenie ZAMKNIĘTE.");
        context.setState(new ClosedState());
    }

    @Override
    public String getStatus() {
        return "ROZWIĄZANE";
    }
}
// Koniec, Tydzień 7, Wzorzec State 3