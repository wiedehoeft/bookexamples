import fit.ColumnFixture;
import videostore.Rental;
import videostore.UnknownMovieException;
import videostore.VideoStore;

public class RentalEntry extends ColumnFixture {

  private VideoStore store = SystemUnderTest.instance();

  public int movieNumber;
  public int daysRented;

  public double charge() throws UnknownMovieException {
    Rental rental = store.addRental(movieNumber, daysRented);
    return rental.getCharge().getAmount();
  }
}
