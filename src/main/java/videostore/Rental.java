package videostore;

public class Rental implements IRental {

  private String movieTitle;
  private IPrice price;

  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Rental(String movieTitle, IPrice price, int daysRented) {
    this.movieTitle = movieTitle;
    this.price = price;
    this.daysRented = daysRented;
  }

  public Euro getCharge() {
    return movie.getCharge(daysRented);
  }

  public String getMovieTitle() {
    return movie.getTitle();
  }

  @Override
  public void printOn(IStatement statement) throws OutOfPaperException {
    statement.printMovieTitle(movieTitle);
    price.printOn(statement, daysRented);
  }

  public int getDaysRented() {
    return daysRented;
  }

  public int getMovieNumber() {
    return movie.getNumber();
  }

  public Movie getMovie() {
    return movie;
  }
}
