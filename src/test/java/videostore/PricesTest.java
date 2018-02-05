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
  public void testNewRelease() throws Exception {

    // Given
    Price price = Prices.getPrice("new release");

    //Expect
    assertSame(Price.NEWRELEASE, price);
  }

  @Test
  public void unknownCategory() {
    assertNull(Prices.getPrice("unknown"));
  }
}
