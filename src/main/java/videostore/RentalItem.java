package videostore;

public class RentalItem {
  public int movieNumber;
  public String movieTitle;
  public int totalDaysRented = 0;

  public RentalItem(Movie movie) {
    movieNumber = movie.getNumber();
    movieTitle = movie.getTitle();
  }

  public void addRental(Rental rental) {
    totalDaysRented += rental.getDaysRented();
  }
}
