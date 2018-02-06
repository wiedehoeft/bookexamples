package videostore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EuroTest {

  private Euro two;

  @Before
  public void setUp() throws Exception {
    two = new Euro(2.00);
  }

  @Test
  public void rounding() throws Exception {
    Assert.assertEquals(new Euro(0.49), new Euro(0.494));
    Assert.assertEquals(new Euro(0.50), new Euro(0.495));
  }

  @Test
  public void adding() throws Exception {
    Euro sum = two.plus(two);

    Assert.assertEquals(sum, new Euro(4.00));
    Assert.assertEquals(two, new Euro(2.00));
  }

  @Test
  public void testEquality() throws Exception {
    Assert.assertEquals(two, two);
    Assert.assertEquals(two, new Euro(2.00));
    Assert.assertEquals(new Euro(2.00), two);

    assertFalse(two.equals(new Euro(7.00)));
    assertFalse(two.equals(null));
    assertFalse(two.equals(new Object()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAmount() throws Exception {
    final double NEGATIVE_AMOUNT = -2.00;
    new Euro(NEGATIVE_AMOUNT);
  }

  @Test
  public void testMultiplying() throws Exception {
    Euro result = two.times(7);
    Assert.assertEquals(new Euro(14.00), result);
    Assert.assertEquals(new Euro(2.00), two);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeMultiplying() throws Exception {
    two.times(-2);
  }

  @Test
  public void testFormatting() throws Exception {
    Assert.assertEquals("2,00", two.format());
  }

  @Test
  public void parsing() throws Exception {

    // Given
    String euroText = "EUR 2.00";

    //When
    Euro parsed = Euro.parse(euroText);

    //Then
    assertEquals(two, parsed);
  }

  @Test
  public void invariant() throws Exception {

    //Expect
    assertEquals(two, Euro.parse(two.toString()));
  }

  @Test(expected = ParseException.class)
  public void parseException() throws Exception {

    // Given
    String euroText = "2.00";

    //When
    Euro.parse(euroText);

    //Then => Exception
  }
}