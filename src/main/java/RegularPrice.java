public class RegularPrice {

    private static final Euro BASE_PRICE = new Euro(1.50);
    private static final Euro PRICE_PER_DAY = new Euro(1.50);
    private static final int DAYS_DISCOUNTED = 3;

    public Euro getCharge(int daysRented) {

        if (daysRented <= DAYS_DISCOUNTED) {
            return BASE_PRICE;
        }

        return BASE_PRICE.add(PRICE_PER_DAY);
    }
}
