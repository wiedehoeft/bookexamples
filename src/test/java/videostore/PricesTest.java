package videostore;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class PricesTest {

  @Test
  public void regularPrice() {
    Price price = Prices.getPrice("regular price");
    assertSame(Price.REGULAR, price);
  }

  @Test
  public void unknownCategory() {
    assertNull(Prices.getPrice("unknown"));
  }
}
