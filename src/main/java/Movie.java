public class Movie {

    public static Euro  getCharge(int daysRented) {
        return Price.NEWRELEASE.getCharge(daysRented);
    }
}
