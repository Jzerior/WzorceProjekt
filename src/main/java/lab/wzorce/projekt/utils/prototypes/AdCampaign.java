package lab.wzorce.projekt.utils.prototypes;

public class AdCampaign implements Cloneable {
    private String campaignName;
    private String targetAudience;
    private double budget;
    private String platform;

    public AdCampaign(String campaignName, String targetAudience, double budget, String platform) {
        this.campaignName = campaignName;
        this.targetAudience = targetAudience;
        this.budget = budget;
        this.platform = platform;
    }

    public String getCampaignName() { return campaignName; }
    public void setCampaignName(String campaignName) { this.campaignName = campaignName; }
    public String getTargetAudience() { return targetAudience; }
    public void setTargetAudience(String targetAudience) { this.targetAudience = targetAudience; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    @Override
    public AdCampaign clone() {
        try {
            return (AdCampaign) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Klonowanie nie jest wspierane", e);
        }
    }

    @Override
    public String toString() {
        return "AdCampaign{name='" + campaignName + "', audience='" + targetAudience +
                "', budget=" + budget + " PLN, platform='" + platform + "'}";
    }
}