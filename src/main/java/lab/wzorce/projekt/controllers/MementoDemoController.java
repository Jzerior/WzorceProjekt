package lab.wzorce.projekt.controllers;

import lab.wzorce.projekt.utils.mementos.cart.*;
import lab.wzorce.projekt.utils.mementos.editor.*;
import lab.wzorce.projekt.utils.mementos.settings.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Tydzień 5, Wzorzec Mediator 1, 2, 3 (TEST)
 * Sprawdzenie działania.
 */

@RestController
@RequestMapping("/api/demo/memento")
public class MementoDemoController {

    @GetMapping("/cart")
    public Map<String, String> testCartUndo() {
        Map<String, String> result = new LinkedHashMap<>();
        ShoppingCart cart = new ShoppingCart();
        CartCaretaker caretaker = new CartCaretaker();

        cart.addItem("Wędka");
        caretaker.backup(cart);
        result.put("Krok 1 (Baza)", cart.save().getItems().toString());

        cart.addItem("Spławik");
        result.put("Krok 2 (Dodano)", cart.save().getItems().toString());

        caretaker.undo(cart);
        result.put("Krok 3 (Cofnięto - Undo)", cart.save().getItems().toString());

        return result;
    }

    @GetMapping("/editor")
    public Map<String, String> testEditor() {
        Map<String, String> result = new LinkedHashMap<>();
        ProductEditor editor = new ProductEditor();
        EditorHistory history = new EditorHistory();

        editor.type("Kij wędkarski. ");
        history.saveState(editor);

        editor.type("Wersja z włókna węglowego. ");
        result.put("Przed cofnięciem", editor.getContent());

        history.undo(editor);
        result.put("Po cofnięciu", editor.getContent());

        return result;
    }

    @GetMapping("/settings")
    public Map<String, String> testSettingsBackup() {
        Map<String, String> result = new LinkedHashMap<>();
        ShopSettings settings = new ShopSettings();

        settings.setConfig("PLN", "Jasny Motyw");
        SettingsMemento backup = settings.backup();
        result.put("1_Konfiguracja_Początkowa", settings.printConfig());

        settings.setConfig("USD", "Brak Motywu (BŁĄD)");
        result.put("2_Błędna_Zmiana", settings.printConfig());

        settings.restore(backup);
        result.put("3_Po_Przywróceniu_Kopii", settings.printConfig());

        return result;
    }
}

// Koniec, Tydzień 5, Wzorzec Memento 1, 2, 3 (TEST)