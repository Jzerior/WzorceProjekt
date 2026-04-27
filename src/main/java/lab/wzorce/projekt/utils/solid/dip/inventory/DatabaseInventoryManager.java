package lab.wzorce.projekt.utils.solid.dip.inventory;
import org.springframework.stereotype.Service;

// Tydzień 8, Zasada DIP
//Konkretna implementacja klasy abstrakcyjnej, a co za tym idzie interfejsu
@Service
public class DatabaseInventoryManager extends BaseInventoryManager {
    public DatabaseInventoryManager() {
        super("MAG-01");
    }

    @Override
    public boolean checkStock(String productId) {
        System.out.println("Sprawdzanie stanu dla produktu " + productId + " w magazynie " + warehouseId);
        return true;
    }
}
// Koniec, Tydzień 8, Zasada DIP