package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.composites.catalog.ProductCategory;
import lab.wzorce.projekt.utils.composites.catalog.ProductItem;
import lab.wzorce.projekt.utils.composites.packaging.DeliveryBox;
import lab.wzorce.projekt.utils.composites.packaging.PhysicalProduct;
import lab.wzorce.projekt.utils.composites.personnel.Department;
import lab.wzorce.projekt.utils.composites.personnel.Worker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tydzień 3, Wzorzec Composite 1, 2, 3 (TEST),
 * Sprawdzenie działania kompozytów.
 */

@RestController
@RequestMapping("/api/demo/composite")
public class CompositeDemoController {

    @GetMapping("/catalog")
    public String testCatalog() {
        ProductCategory fishing = new ProductCategory("Wędkarstwo");

        fishing.addComponent(new ProductItem("Wędka", 1500.0));
        fishing.addComponent(new ProductItem("Spławik", 150.0));

        return "Całkowita wartość asortymentu w kategorii Wędkarstwo: " + fishing.getPrice() + " PLN";
    }

    @GetMapping("/personnel")
    public String testPersonnelHierarchy() {
        Department mainDepartment = new Department("Zarząd Sklepu");

        Department salesDept = new Department("Dział Sprzedaży");
        Department deliveryDept = new Department("Dział Logistyki i Dostaw");

        salesDept.addComponent(new Worker("Jan Kowalski", "Sprzedawca-Doradca", 4500.0));
        salesDept.addComponent(new Worker("Anna Nowak", "Kierownik Sklepu", 6500.0));

        deliveryDept.addComponent(new Worker("Piotr Wiśniewski", "Kurier", 4000.0));
        deliveryDept.addComponent(new Worker("Tomasz Wójcik", "Kierowca C", 5000.0));

        mainDepartment.addComponent(salesDept);
        mainDepartment.addComponent(deliveryDept);

        mainDepartment.addComponent(new Worker("Marta Kamińska", "Główna Księgowa", 8000.0));

        StringBuilder response = new StringBuilder();
        response.append("<h3>Struktura firmy:</h3>");
        response.append("<pre>");

        mainDepartment.printHierarchy("");

        response.append("Struktura została wydrukowana w konsoli serwera.\n\n");
        response.append("Budżet miesięczny dla Działu Sprzedaży: ").append(salesDept.getSalary()).append(" PLN\n");
        response.append("Budżet miesięczny dla całego Sklepu: ").append(mainDepartment.getSalary()).append(" PLN");
        response.append("</pre>");

        return response.toString();
    }

    @GetMapping("/packaging")
    public String testPackagingHierarchy() {
        DeliveryBox mainBox = new DeliveryBox(0.5);

        DeliveryBox fishingBox = new DeliveryBox(0.2);
        fishingBox.addItem(new PhysicalProduct("Wędka", 1.2));
        fishingBox.addItem(new PhysicalProduct("Zestaw spławików", 0.5));

        DeliveryBox modelingEnvelope = new DeliveryBox(0.05);
        modelingEnvelope.addItem(new PhysicalProduct("Zestaw pędzelków", 0.15));
        modelingEnvelope.addItem(new PhysicalProduct("Farbki olejne", 0.50));

        PhysicalProduct freeCatalog = new PhysicalProduct("Katalog produktów 2026", 0.3);

        mainBox.addItem(fishingBox);
        mainBox.addItem(modelingEnvelope);
        mainBox.addItem(freeCatalog);

        StringBuilder response = new StringBuilder();
        response.append("<h3>Logistyka - Obliczanie wagi przesyłki</h3>");
        response.append("<pre>");

        response.append("Struktura paczki głównej:\n");
        response.append(" |- Pudełko wędkarskie\n");
        response.append(" |- Koperta z akcesoriami modelarskimi\n");
        response.append(" |- Katalog\n\n");

        response.append("Waga pudełka wędkarskiego: ").append(fishingBox.getWeight()).append(" kg\n");
        response.append("Waga koperty akcesoriami modelarskimi: ").append(modelingEnvelope.getWeight()).append(" kg\n");
        response.append("Waga samego katalogu: ").append(freeCatalog.getWeight()).append(" kg\n");
        response.append("--------------------------------------------------\n");

        response.append("<b>Całkowita waga przesyłki (z opakowaniami): ").append(mainBox.getWeight()).append(" kg</b>\n");
        response.append("</pre>");

        return response.toString();
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 1, 2, 3 (TEST)