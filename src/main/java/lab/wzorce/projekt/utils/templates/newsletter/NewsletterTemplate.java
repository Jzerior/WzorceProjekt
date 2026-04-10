package lab.wzorce.projekt.utils.templates.newsletter;

/**
 * Tydzień 6, Wzorzec Template 3
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public abstract class NewsletterTemplate {

    public final String generateAndSend() {
        StringBuilder log = new StringBuilder();
        log.append(fetchAudience());
        log.append(buildContent());
        log.append(dispatchEmails());
        return log.toString();
    }

    protected abstract String fetchAudience();
    protected abstract String buildContent();

    protected String dispatchEmails() {
        return "[Mail Sender] Wysyłanie przez serwer SMTP.\n";
    }
}

// Koniec, Tydzień 6, Wzorzec Template 3