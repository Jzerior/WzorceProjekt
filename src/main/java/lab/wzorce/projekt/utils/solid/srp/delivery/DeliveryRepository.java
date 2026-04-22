package lab.wzorce.projekt.utils.solid.srp.delivery;

// Tydzień 7, Zasada SRP (Single Responsibility Principle)
// Klasa odpowiada WYŁĄCZNIE za komunikację z bazą danych / warstwę utrwalania.
public class DeliveryRepository {

    public String saveDeliveryOrder(Delivery delivery) {
        // Symulacja zapisu do bazy danych
        return "Pomyślnie zapisano zlecenie dostawy do bazy danych dla paczki na adres: " + delivery.getAddress();
    }
}
// Koniec, Tydzień 7, Zasada SRP