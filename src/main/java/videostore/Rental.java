package videostore;

public class Rental implements IRental {

  private String movieTitle;
  private IPrice price;
  private int daysRented;

  public Rental(String movieTitle, IPrice price, int daysRented) {
    this.movieTitle = movieTitle;
    this.price = price;
    this.daysRented = daysRented;
  }

  @Override
  public void printOn(IStatement statement) {
    statement.printMovieTitle(movieTitle);
    price.printOn(statement, daysRented);
  }
}
