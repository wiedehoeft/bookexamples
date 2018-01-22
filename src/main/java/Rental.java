public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Euro getCharge() {
        return movie.getCharge(daysRented);
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }
}
