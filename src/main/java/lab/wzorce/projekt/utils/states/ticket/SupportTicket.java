package lab.wzorce.projekt.utils.states.ticket;

// Tydzień 7, Wzorzec State 3
/**
 * Kontekst dla maszyny stanów zgłoszeń supportu.
 */
public class SupportTicket {
    private TicketState state;
    private final String issueDescription;

    public SupportTicket(String issueDescription) {
        this.issueDescription = issueDescription;
        this.state = new NewTicketState(); // Domyślnie nowe zgłoszenie
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    public void assign() {
        state.assign(this);
    }

    public void resolve() {
        state.resolve(this);
    }

    public void close() {
        state.close(this);
    }

    public String getStatus() {
        return state.getStatus() + " | Zgłoszenie: " + issueDescription;
    }
}
// Koniec, Tydzień 7, Wzorzec State 3