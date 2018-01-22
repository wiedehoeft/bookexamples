import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testBasePrice() throws Exception {
        assertEquals(2.00, Movie.tmpCharge(1).getAmount(), 0.01);
        assertEquals(2.00, Movie.tmpCharge(1).getAmount(), 0.01);
    }

    @Test
    public void testPricePerPay() throws Exception {
        assertEquals(3.75, Movie.tmpCharge(3).getAmount(), 0.01);
        assertEquals(5.50, Movie.tmpCharge(4).getAmount(), 0.01);
    }
}
