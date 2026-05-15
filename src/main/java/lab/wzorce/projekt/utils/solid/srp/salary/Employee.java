package lab.wzorce.projekt.utils.solid.srp.salary;

// Tydzień 7, Zasada SRP
// Klasa modelu (Data Holder). Jej jedynym powodem do zmiany jest zmiana struktury
// danych pracownika (np. dodanie numeru konta). Nie ma tu żadnej logiki biznesowej.
public class Employee {
    private final String name;
    private final double grossSalary;

    public Employee(String name, double grossSalary) {
        // Tydzień 9, Clena Code - exception example
        if (grossSalary < 0) {
            throw new IllegalArgumentException("Wynagrodzenie brutto nie może być wartością ujemną. Przekazano: " + grossSalary);
        }
        // Koniec, Tydzień 9, Clean Code -exception example

        this.name = name;
        this.grossSalary = grossSalary;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }
}
// Koniec, Tydzień 7, Zasada SRP