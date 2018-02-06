import fit.ColumnFixture;
import videostore.Euro;
import videostore.Price;

public class Pricing extends ColumnFixture {

  public int daysRented;

  public Euro regularPrice() {
    return Price.REGULAR.getCharge(daysRented);
  }

  public Euro newRelease() {
    return Price.NEWRELEASE.getCharge(daysRented);
  }

  @Override
  public Object parse(String text, Class type) throws Exception {
    if(Euro.class.equals(type)) {
      return Euro.parse(text);
    }
    return super.parse(text, type);
  }
}
