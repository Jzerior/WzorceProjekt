package lab.wzorce.projekt.utils.states.ticket;

// Tydzień 7, Wzorzec State 3
public class InProgressState implements TicketState {
    @Override
    public void assign(SupportTicket context) {
        System.out.println("BŁĄD: Zgłoszenie jest już w trakcie realizacji.");
    }

    @Override
    public void resolve(SupportTicket context) {
        System.out.println("Problem klienta rozwiązany. Status zmieniony na ROZWIĄZANE.");
        context.setState(new ResolvedState());
    }

    @Override
    public void close(SupportTicket context) {
        System.out.println("BŁĄD: Nie można zamknąć trwającego zgłoszenia. Najpierw je rozwiąż.");
    }

    @Override
    public String getStatus() {
        return "W_REALIZACJI";
    }
}
// Koniec, Tydzień 7, Wzorzec State 3