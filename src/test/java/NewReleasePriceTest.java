import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewReleasePriceTest {

    @Test
    public void testBasePrice() throws Exception {
        assertEquals(new Euro(2.00), Movie.getCharge(1));
        assertEquals(new Euro(2.00), Movie.getCharge(1));
    }

    @Test
    public void testPricePerPay() throws Exception {
        assertEquals(new Euro(3.75), Movie.getCharge(3));
        assertEquals(new Euro(5.50), Movie.getCharge(4));
    }
}