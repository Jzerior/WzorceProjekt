package lab.wzorce.projekt.utils.solid.srp.salary;

// Tydzień 7, Zasada SRP
// Klasa odpowiada WYŁĄCZNIE za zapisywanie danych (np. do bazy danych lub pliku).
public class SalaryRepository {

    public String saveReport(Employee employee) {
        // Symulacja operacji bazodanowej
        String log = "[Baza Danych] Pomyślnie zarchiwizowano raport płacowy dla: " + employee.getName();
        System.out.println(log);
        return log;
    }
}
// Koniec, Tydzień 7, Zasada SRP