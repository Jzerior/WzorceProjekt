package lab.wzorce.projekt.utils.solid.dip.inventory;

// Tydzień 8, Zasada DIP
//Bazowy interfejs, abstrakcja na której mogą polegać moduły wysokopoziomowe
public interface InventoryManager {
    boolean checkStock(String productId);
}
// Koniec, Tydzień 8, Zasada DIP