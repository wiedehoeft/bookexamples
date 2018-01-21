public class Movie {

    private static final double BASE_PRICE = 2.0;
    private static final double PRICE_PER_DAY = 1.75;
    private static final int DAYS_DISCOUNTED = 2;

    public static double getCharge(int daysRented) {
        double result = BASE_PRICE;

        if(daysRented > DAYS_DISCOUNTED) {
            result += (daysRented - DAYS_DISCOUNTED) * PRICE_PER_DAY;
        }
        return result;
    }
}
