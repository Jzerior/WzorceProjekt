package lab.wzorce.projekt.utils.templates.order;

/**
 * Tydzień 6, Wzorzec Template 1
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public class PreOrderProcessor extends OrderProcessorTemplate {
    @Override
    protected String checkAvailability() {
        return "- Rezerwacja w systemie przedsprzedaży. Oczekiwanie na premierę.\n";
    }
    @Override
    protected String prepareItem() {
        return "- Pakowanie ze specjalnym prezentem dla pre-orderów.\n";
    }
    @Override
    protected String ship() {
        return "- Wysyłka priorytetowa na dzień przed premierą.\n";
    }
}

// Koniec, Tydzień 6, Wzorzec Template 1