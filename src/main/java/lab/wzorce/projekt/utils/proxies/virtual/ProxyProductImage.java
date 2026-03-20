package lab.wzorce.projekt.utils.proxies.virtual;

// Tydzień 4, Wzorzec Proxy 1 (Virtual Proxy)
// Pełnomocnik, który opóźnia ładowanie prawdziwego obrazu do momentu wywołania metody display().
public class ProxyProductImage implements ProductImage {
    private RealProductImage realImage;
    private final String filename;

    public ProxyProductImage(String filename) {
        this.filename = filename;
    }

    @Override
    public String display() {
        if (realImage == null) {
            realImage = new RealProductImage(filename);
        }
        return realImage.display();
    }
}