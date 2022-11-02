public class TieredRateTable {
    final double[][] pairs;

    TieredRateTable(double... tiers) {
        pairs = new double[tiers.length / 2][];
        for (int i = 0; i < tiers.length; i += 2) {
            pairs[i / 2] = new double[]{tiers[i], tiers[i + 1]};
        }
    }

    double map(double amount) {
        double charge = 0;

        for (int i = 0; i < pairs.length; i++) {
            if (i + 1 < pairs.length && amount > pairs[i + 1][0]) {
                charge += (pairs[i + 1][0] - pairs[i][0]) * pairs[i][1];
            } else {
                charge += (amount - pairs[i][0]) * pairs[i][1];
                break;
            }
        }
        return charge;
    }
}
