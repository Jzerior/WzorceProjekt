package lab.wzorce.projekt.utils.prototypes;

public class DiscountCoupon implements Cloneable {
    private String code;
    private double discountPercentage;
    private boolean isActive;

    public DiscountCoupon(String code, double discountPercentage, boolean isActive) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.isActive = isActive;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public DiscountCoupon clone() {
        try {
            return (DiscountCoupon) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Klonowanie nie jest wspierane", e);
        }
    }

    @Override
    public String toString() {
        return "DiscountCoupon{code='" + code + "', discount=" + discountPercentage + "%, active=" + isActive + "}";
    }
}