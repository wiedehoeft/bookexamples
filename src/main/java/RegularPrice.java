public class RegularPrice {

    private static final Euro BASE_PRICE = new Euro(1.50);
    private static final Euro PRICE_PER_DAY = new Euro(1.50);
    private static final int DAYS_DISCOUNTED = 3;

    public Euro getCharge(int daysRented) {

        if (daysRented <= DAYS_DISCOUNTED) {
            return BASE_PRICE;
        }

        int additionalDays = daysRented - DAYS_DISCOUNTED;

        return BASE_PRICE.plus(PRICE_PER_DAY.times(additionalDays));
    }
}
