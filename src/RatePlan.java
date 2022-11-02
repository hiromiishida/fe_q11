public class RatePlan {
    private final String name;
    private final double basicCharge;
    private final TieredRateTable pricingTiers;

    RatePlan(String name, double basicCharge, TieredRateTable pricingTiers) {
        this.name = name;
        this.basicCharge = basicCharge;
        this.pricingTiers = pricingTiers;
    }

    String getName() {
        return name;
    }

    int getPrice(double amount){
        return (int) (basicCharge + pricingTiers.map(amount));
    }
}
