package lab.wzorce.projekt.utils.prototypes;

// Tydzień 1, Wzorzec Prototyp 1
// Wzorzec projektowy Prototyp zaimplementowany z wykorzystaniem natywnego interfejsu Cloneable.
// Umożliwia tworzenie dokładnych kopii  obiektu Product za pomocą nadpisanej metody clone(), co pozwala na szybkie powielanie przygotowanych instancji.
public class Product implements Cloneable {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Klonowanie nie jest wspierane", e);
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", category='" + category + "'}";
    }
}
// Koniec, Tydzień 1, Wzorzec Prototyp 1.