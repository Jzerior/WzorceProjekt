package lab.wzorce.projekt.utils.templates.order;

/**
 * Tydzień 6, Wzorzec Template 1
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public abstract class OrderProcessorTemplate {

    public final String processOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append(checkAvailability());
        sb.append(prepareItem());
        sb.append(ship());
        return sb.toString();
    }

    protected abstract String checkAvailability();
    protected abstract String prepareItem();

    protected String ship() {
        return "- Wysyłka standardowym kurierem.\n";
    }
}

// Koniec, Tydzień 6, Wzorzec Template 1