package lab.wzorce.projekt.utils.solid.srp;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa odpowiada WYŁĄCZNIE za utrwalanie danych (zapis do bazy/systemu plików).
// Reszta systemu nie musi wiedzieć jak i gdzie faktury są przechowywane.
public class InvoiceRepository {

    public String saveToDatabase(Invoice invoice) {
        // Symulacja logiki zapisu do bazy danych
        String log = "[Baza Danych] Pomyślnie zapisano fakturę dla klienta: " + invoice.getCustomerName();
        System.out.println(log);
        return log;
    }
}
// Koniec, Tydzień 7, Zasada SRP