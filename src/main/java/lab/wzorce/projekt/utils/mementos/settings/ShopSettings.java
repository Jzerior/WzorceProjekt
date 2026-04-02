package lab.wzorce.projekt.utils.mementos.settings;

/**
 * Tydzień 5, Wzorzec Memento 3
 * Zapisywanie i przywracanie wewnętrznego stanu obiektu bez naruszania jego hermetyzacji.
 * Przydatne do implementacji mechanizmów cofania jakiegoś działania.
 */

public class ShopSettings {
    private String currency;
    private String theme;

    public void setConfig(String currency, String theme) {
        this.currency = currency; this.theme = theme;
    }
    public String printConfig() { return "Waluta: " + currency + ", Motyw: " + theme; }

    public SettingsMemento backup() { return new SettingsMemento(currency, theme); }
    public void restore(SettingsMemento memento) {
        this.currency = memento.getCurrency();
        this.theme = memento.getTheme();
    }
}

// Koniec, Tydzień 5, Wzorzec Memento 3
