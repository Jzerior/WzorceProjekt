package lab.wzorce.projekt.utils.singletons;

public enum AuditLogger {

    //Enum singleton
    INSTANCE;

    private final String logPrefix = "[SKLEP-AUDYT] ";

    public void log(String message) {
        // W przyszłości będzie tutaj zapis do bazy danych oraz do plików
        System.out.println(logPrefix + message);
    }
}