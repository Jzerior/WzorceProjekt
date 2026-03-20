package lab.wzorce.projekt.utils.proxies.protection;

// Tydzień 4, Wzorzec Proxy 2 (Protection Proxy)
// Obiekt docelowy, który wykonuje właściwą, chronioną operację.
public class RealFinancialReport implements FinancialReport {
    @Override
    public String generateReport() {
        return "Poufne dane finansowe sklepu: Przychód 1,500,000 PLN, Koszty operacyjne: 800,000 PLN.";
    }
}