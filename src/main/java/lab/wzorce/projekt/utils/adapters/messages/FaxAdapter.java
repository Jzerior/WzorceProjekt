package lab.wzorce.projekt.utils.adapters.messages;

import lab.wzorce.projekt.utils.bridges.messages.MessageSender;

// Tydzień 2, Wzorzec Adapter 2
// Wzorzec projektowy Adapter umożliwiający współpracę niekompatybilnego
// systemu LegacyFaxSystem z nowoczesnym interfejsem MessageSender poprzez mapowanie metod.
public class FaxAdapter implements MessageSender {
    private LegacyFaxSystem faxSystem;

    public FaxAdapter(LegacyFaxSystem faxSystem) {
        this.faxSystem = faxSystem;
    }

    @Override
    public String sendMessage(String message) {
        faxSystem.printFax(message, 1);
        return "[FAX] Wiadomość wysłana przez adapter: " + message;
    }
}
// Koniec, Tydzień 2, Wzorzec Adapter 2.