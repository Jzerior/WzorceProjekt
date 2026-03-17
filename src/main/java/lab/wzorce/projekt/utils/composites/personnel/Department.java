package lab.wzorce.projekt.utils.composites.personnel;

import java.util.ArrayList;
import java.util.List;

/**
 * Tydzień 3, Wzorzec Composite 3,
 * Struktura Organizacyjna Firmy
 * Służy do budowania drzewiastej hierarchii pracowników.
 * Interfejs jest implementowany zarówno przez pojedynczego pracownika,
 * jak i przez cały dział. Umożliwia to np. łatwe i rekurencyjne
 * wyliczanie sumy pensji dla dowolnego szczebla organizacji.
 */

public class Department implements EmployeeComponent {
    private String departmentName;
    private List<EmployeeComponent> components = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addComponent(EmployeeComponent component) {
        components.add(component);
    }

    public void removeComponent(EmployeeComponent component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return departmentName;
    }

    @Override
    public double getSalary() {
        return components.stream()
                .mapToDouble(EmployeeComponent::getSalary)
                .sum();
    }

    @Override
    public void printHierarchy(String indent) {
        System.out.println(indent + "+ Dział: " + departmentName);
        for (EmployeeComponent component : components) {
            component.printHierarchy(indent + "   ");
        }
    }
}

// Koniec, Tydzień 3, Wzorzec Composite 3