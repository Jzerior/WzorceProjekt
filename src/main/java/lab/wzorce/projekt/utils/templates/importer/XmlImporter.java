package lab.wzorce.projekt.utils.templates.importer;

/**
 * Tydzień 6, Wzorzec Template 2
 * Metoda Szablonowa definiuje szkielet ogólnego algorytmu w klasie abstrakcyjnej,
 * pozwalając klasom potomnym na nadpisanie tylko jego specyficznych kroków bez
 * modyfikowania samej struktury. Opiera się to na dziedziczeniu,
 * co ułatwia wielokrotne użycie głównej logiki procesu i skutecznie zapobiega powielaniu kodu.
 */

public class XmlImporter extends DataImporterTemplate {
    @Override
    protected String openFile() { return "[XML] Otwieranie pliku dane.xml...\n"; }
    @Override
    protected String parseData() { return "[XML] Odczyt tagów przy użyciu DOM parsera...\n"; }
}

// Koniec, Tydzień 6, Wzorzec Template 2