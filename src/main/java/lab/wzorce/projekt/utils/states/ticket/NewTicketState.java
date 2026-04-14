package lab.wzorce.projekt.utils.states.ticket;

// Tydzień 7, Wzorzec State 3
public class NewTicketState implements TicketState {
    @Override
    public void assign(SupportTicket context) {
        System.out.println("Zgłoszenie przypisane do konsultanta. Status zmieniony na W_REALIZACJI.");
        context.setState(new InProgressState());
    }

    @Override
    public void resolve(SupportTicket context) {
        System.out.println("BŁĄD: Nie można rozwiązać zgłoszenia, którego jeszcze nikt nie przypisał.");
    }

    @Override
    public void close(SupportTicket context) {
        System.out.println("BŁĄD: Nowe zgłoszenie nie może zostać od razu zamknięte (najpierw trzeba je rozwiązać).");
    }

    @Override
    public String getStatus() {
        return "NOWE";
    }
}
// Koniec, Tydzień 7, Wzorzec State 3