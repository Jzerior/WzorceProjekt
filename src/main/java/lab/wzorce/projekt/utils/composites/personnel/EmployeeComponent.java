package lab.wzorce.projekt.utils.composites.personnel;

/**
 * Tydzień 3, Wzorzec Composite 3,
 * Struktura Organizacyjna Firmy
 * Służy do budowania drzewiastej hierarchii pracowników.
 * Interfejs jest implementowany zarówno przez pojedynczego pracownika,
 * jak i przez cały dział. Umożliwia to np. łatwe i rekurencyjne
 * wyliczanie sumy pensji dla dowolnego szczebla organizacji.
 */

public interface EmployeeComponent {
    String getName();
    double getSalary();
    void printHierarchy(String indent);
}

// Koniec, Tydzień 3, Wzorzec Composite 3