package lab.wzorce.projekt.utils.composites.personnel;

/**
 * Tydzień 3, Wzorzec Composite 3,
 * Struktura Organizacyjna Firmy
 * Służy do budowania drzewiastej hierarchii pracowników.
 * Interfejs jest implementowany zarówno przez pojedynczego pracownika,
 * jak i przez cały dział. Umożliwia to np. łatwe i rekurencyjne
 * wyliczanie sumy pensji dla dowolnego szczebla organizacji.
 */

public class Worker implements EmployeeComponent {
    private String name;
    private String position;
    private double salary;

    public Worker(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printHierarchy(String indent) {
        System.out.println(indent + "- [" + position + "] " + name + " (" + salary + " PLN)");
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 3