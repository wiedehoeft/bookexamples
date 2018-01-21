import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testBasePrice() throws Exception {
        assertEquals(2.00, Movie.getCharge(1), 0.01);
        assertEquals(2.00, Movie.getCharge(1), 0.01);
    }

    @Test
    public void testPricePerPay() throws Exception {
        assertEquals(3.75, Movie.getCharge(3), 0.01);
        assertEquals(5.50, Movie.getCharge(4), 0.01);
    }
}
