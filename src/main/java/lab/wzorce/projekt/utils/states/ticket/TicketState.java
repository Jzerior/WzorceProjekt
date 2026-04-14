package lab.wzorce.projekt.utils.states.ticket;

// Tydzień 7, Wzorzec State 3
/**
 * Interfejs określający możliwe akcje dla zgłoszenia w dziale wsparcia.
 */
public interface TicketState {
    void assign(SupportTicket context);
    void resolve(SupportTicket context);
    void close(SupportTicket context);
    String getStatus();
}
// Koniec, Tydzień 7, Wzorzec State 3