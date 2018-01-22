public class Movie {

    public static Euro getCharge(int daysRented) {
        return new NewReleasePrice().tmpCharge(daysRented);
    }

}
