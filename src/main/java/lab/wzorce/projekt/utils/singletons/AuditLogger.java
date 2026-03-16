package lab.wzorce.projekt.utils.singletons;

// Tydzień 1, Wzorzec Singleton 1
// Wzorzec projektowy Singleton zaimplementowany za pomocą typu wyliczeniowego - Enum.
// Gwarantuje to utworzenie tylko jednej, globalnie dostępnej instancji obiektu AuditLogger w sposób odporny na wielowątkowość.
public enum AuditLogger {

    INSTANCE;

    private final String logPrefix = "[SKLEP-AUDYT] ";

    public void log(String message) {
        // W przyszłości będzie tutaj zapis do bazy danych oraz do plików
        System.out.println(logPrefix + message);
    }
}
// Koniec, Tydzień 1, Wzorzec Singleton 1.