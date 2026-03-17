package lab.wzorce.projekt.utils.adapters.reports;

public class ExternalJsonGenerator {
    public String createJsonNode(String key, String value) {
        return "{\"" + key + "\": \"" + value + "\"}";
    }
}