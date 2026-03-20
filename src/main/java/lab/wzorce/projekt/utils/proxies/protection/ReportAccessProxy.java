package lab.wzorce.projekt.utils.proxies.protection;

import lab.wzorce.projekt.models.User;

// Tydzień 4, Wzorzec Proxy 2 (Protection Proxy)
// Pełnomocnik sprawdzający uprawnienia obiektu User przed wygenerowaniem raportu.
public class ReportAccessProxy implements FinancialReport {
    private RealFinancialReport realReport;
    private final User requestingUser;

    public ReportAccessProxy(User requestingUser) {
        this.requestingUser = requestingUser;
    }

    @Override
    public String generateReport() {
        // Sprawdzanie uprawnień (przywilej musi być "admin")
        if ("admin".equals(requestingUser.getPrivilege())) {
            if (realReport == null) {
                realReport = new RealFinancialReport();
            }
            return realReport.generateReport();
        } else {
            return "Odmowa dostępu: Tylko użytkownicy z rolą 'admin' mogą przeglądać raporty finansowe.";
        }
    }
}