package lab.wzorce.projekt.utils.mementos.settings;

/**
 * Tydzień 5, Wzorzec Memento 3
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class SettingsMemento {
    private final String currency;
    private final String theme;
    public SettingsMemento(String currency, String theme) {
        this.currency = currency; this.theme = theme;
    }
    public String getCurrency() { return currency; }
    public String getTheme() { return theme; }
}

// Koniec, Tydzień 5, Wzorzec Memento 3
