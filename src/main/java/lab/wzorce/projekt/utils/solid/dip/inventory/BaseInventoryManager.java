package lab.wzorce.projekt.utils.solid.dip.inventory;

// Tydzień 8, Zasada DIP
//Klasa abstrakcyjna, implementująca bazową logikę
public abstract class BaseInventoryManager implements InventoryManager {
    protected String warehouseId;

    public BaseInventoryManager(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public abstract boolean checkStock(String productId);
}
// Koniec, Tydzień 8, Zasada DIP