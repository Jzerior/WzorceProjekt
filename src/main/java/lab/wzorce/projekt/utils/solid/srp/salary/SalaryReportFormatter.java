package lab.wzorce.projekt.utils.solid.srp.salary;

// Tydzień 7, Zasada SRP
// Klasa odpowiada WYŁĄCZNIE za prezentację danych (formatowanie do tekstu).
// Zmiana układu raportu, dodanie nowych sekcji wpłynie tylko na ten plik.
public class SalaryReportFormatter {
    private final SalaryCalculator calculator;

    public SalaryReportFormatter(SalaryCalculator calculator) {
        this.calculator = calculator;
    }

    public String format(Employee employee) {
        StringBuilder report = new StringBuilder();
        report.append("=== RAPORT PŁACOWY ===\n");
        report.append("Pracownik: ").append(employee.getName()).append("\n");
        report.append("Pensja Brutto: ").append(employee.getGrossSalary()).append(" PLN\n");
        report.append("- Podatek dochodowy: ").append(calculator.calculateTax(employee)).append(" PLN\n");
        report.append("- Składki ZUS: ").append(calculator.calculateZus(employee)).append(" PLN\n");
        report.append("----------------------\n");
        report.append("DO WYPŁATY (Netto): ").append(calculator.calculateNetSalary(employee)).append(" PLN\n");

        return report.toString();
    }
}
// Koniec, Tydzień 7, Zasada SRP