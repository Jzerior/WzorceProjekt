package lab.wzorce.projekt.utils.proxies.virtual;

// Tydzień 4, Wzorzec Proxy 1 (Virtual Proxy)
// Prawdziwy obiekt reprezentujący "ciężki" zasób (np. obraz wysokiej rozdzielczości).
// Jego konstrukcja wymaga czasu (symulacja ładowania z dysku).
public class RealProductImage implements ProductImage {
    private final String filename;

    public RealProductImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        // Symulacja opóźnienia przy wczytywaniu pliku
        System.out.println("[Virtual Proxy] Ładowanie wielkiego pliku z dysku: " + filename);
    }

    @Override
    public String display() {
        return "Wyświetlanie pełnego obrazu: " + filename;
    }
}