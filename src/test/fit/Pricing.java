import fit.ColumnFixture;
import videostore.Price;

public class Pricing extends ColumnFixture {

  public int daysRented;

  public double regularPrice() {
    return Price.REGULAR.getCharge(daysRented).getAmount();
  }
}
