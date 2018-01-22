import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceTest {

    @Test
    public void testBasePrice() throws Exception {
        assertEquals(new Euro(2.00), Price.NEWRELEASE.getCharge(1));
        assertEquals(new Euro(2.00), Price.NEWRELEASE.getCharge(1));
    }

    @Test
    public void testPricePerPay() throws Exception {
        assertEquals(new Euro(3.75), Price.NEWRELEASE.getCharge(3));
        assertEquals(new Euro(5.50), Price.NEWRELEASE.getCharge(4));
    }
}