package lab.wzorce.projekt.utils.templates.importer;

/**
 * Tydzień 6, Wzorzec Template 2
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public class CsvImporter extends DataImporterTemplate {
    @Override
    protected String openFile() { return "[CSV] Otwieranie pliku dane.csv...\n"; }
    @Override
    protected String parseData() { return "[CSV] Podział danych po średnikach...\n"; }
}

// Koniec, Tydzień 6, Wzorzec Template 2