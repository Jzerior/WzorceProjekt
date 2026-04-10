package lab.wzorce.projekt.utils.templates.order;

/**
 * Tydzień 6, Wzorzec Template 1
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public class StandardOrderProcessor extends OrderProcessorTemplate {
    @Override
    protected String checkAvailability() {
        return "- Sprawdzanie stanu magazynowego (Dostępne).\n";
    }
    @Override
    protected String prepareItem() {
        return "- Pakowanie w standardowy karton.\n";
    }
}

// Koniec, Tydzień 6, Wzorzec Template 1