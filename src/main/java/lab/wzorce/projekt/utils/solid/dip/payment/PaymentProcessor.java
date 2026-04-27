package lab.wzorce.projekt.utils.solid.dip.payment;

// Tydzień 8, Zasada DIP
//Bazowy interfejs, abstrakcja na której mogą polegać moduły wysokopoziomowe
public interface PaymentProcessor {
    boolean processPayment(double amount);
}
// Koniec, Tydzień 8, Zasada DIP