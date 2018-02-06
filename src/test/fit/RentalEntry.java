import fit.ColumnFixture;
import videostore.Euro;
import videostore.Rental;
import videostore.UnknownMovieException;
import videostore.VideoStore;

public class RentalEntry extends ColumnFixture {

  private VideoStore store = SystemUnderTest.instance();

  public int[] daysRented;
  public int movieNumber;

  public Euro[] charges() throws UnknownMovieException {
    Euro[] result = new Euro[daysRented.length];

    for (int i = 0; i < daysRented.length; i++) {
      Rental rental = store.addRental(movieNumber, daysRented[i]);
      result[i] = rental.getCharge();
    }

    return result;
  }

  public Object parse(String text, Class type) throws Exception {
    if (Euro.class.equals(type)) {
      return Euro.parse(text);
    }
    return super.parse(text, type);
  }
}
