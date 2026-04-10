package lab.wzorce.projekt.utils.templates.importer;

/**
 * Tydzień 6, Wzorzec Template 2
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public abstract class DataImporterTemplate {

    public final String runImport() {
        StringBuilder result = new StringBuilder();
        result.append(openFile());
        result.append(parseData());
        result.append(saveToDatabase());
        return result.toString();
    }

    protected abstract String openFile();
    protected abstract String parseData();

    protected String saveToDatabase() {
        return "[Baza Danych] Zapisywanie przetworzonych wierszy do bazy H2.\n";
    }
}

// Koniec, Tydzień 6, Wzorzec Template 2
