package lab.wzorce.projekt.utils.solid.srp.salary;

// Tydzień 7, Zasada SRP
// Klasa odpowiada WYŁĄCZNIE za logikę biznesową (obliczenia finansowe).
// Jeśli zmieni się prawo podatkowe lub składki ZUS, modyfikujemy TYLKO tę klasę.
public class SalaryCalculator {
    private static final double TAX_RATE = 0.18;
    private static final double ZUS_RATE = 0.09;

    public double calculateTax(Employee employee) {
        return employee.getGrossSalary() * TAX_RATE;
    }

    public double calculateZus(Employee employee) {
        return employee.getGrossSalary() * ZUS_RATE;
    }

    public double calculateNetSalary(Employee employee) {
        return employee.getGrossSalary() - calculateTax(employee) - calculateZus(employee);
    }
}
// Koniec, Tydzień 7, Zasada SRP