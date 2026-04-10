package lab.wzorce.projekt.utils.templates.newsletter;

/**
 * Tydzień 6, Wzorzec Template 3
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public class SystemUpdateNewsletter extends NewsletterTemplate {
    @Override
    protected String fetchAudience() { return "Pobieranie listy: Wszyscy zarejestrowani.\n"; }
    @Override
    protected String buildContent() { return "Szanowny Kliencie, informujemy o zmianie regulaminu...\n"; }
}

// Koniec, Tydzień 6, Wzorzec Template 3