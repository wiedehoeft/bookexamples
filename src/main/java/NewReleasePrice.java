public class NewReleasePrice {

    private static final Euro BASE_PRICE = new Euro(2.00);
    private static final Euro PRICE_PER_DAY = new Euro(1.75);
    private static final int DAYS_DISCOUNTED = 2;

    public static Euro getCharge(int daysRented) {
        Euro result = BASE_PRICE;
        if (daysRented > DAYS_DISCOUNTED) {
            int additionalDays = daysRented - DAYS_DISCOUNTED;
            result = result.plus(PRICE_PER_DAY.times(additionalDays));
        }
        return result;
    }
}
