package lab.wzorce.projekt.utils.adapters.messages;

public class LegacyFaxSystem {
    public void printFax(String text, int priority) {
        System.out.println("Fax: " + text + " [Priorytet: " + priority + "]");
    }
}