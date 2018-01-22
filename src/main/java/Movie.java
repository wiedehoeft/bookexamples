public class Movie {

    public static Euro getCharge(int daysRented) {
        return new NewReleasePrice().getCharge(daysRented);
    }
}
