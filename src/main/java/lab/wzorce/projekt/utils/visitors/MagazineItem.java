package lab.wzorce.projekt.utils.visitors;

public class MagazineItem implements VisitableItem {
    private final String title;
    private final double price;
    private final int issueNumber;

    public MagazineItem(String title, double price, int issueNumber) {
        this.title = title;
        this.price = price;
        this.issueNumber = issueNumber;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }
    public int getIssueNumber() { return issueNumber; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}