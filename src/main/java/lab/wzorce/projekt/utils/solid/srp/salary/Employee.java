package lab.wzorce.projekt.utils.solid.srp.salary;

// Tydzień 7, Zasada SRP
// Klasa modelu (Data Holder). Jej jedynym powodem do zmiany jest zmiana struktury
// danych pracownika (np. dodanie numeru konta). Nie ma tu żadnej logiki biznesowej.
public class Employee {
    private final String name;
    private final double grossSalary;

    public Employee(String name, double grossSalary) {
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