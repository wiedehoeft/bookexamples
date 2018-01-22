import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularPriceTest {

    private RegularPrice price;

    @Before
    public void setUp() throws Exception {
        price = new RegularPrice();
    }

    @Test
    public void testChargingOneDayRental() throws Exception {
        assertEquals(new Euro(1.50), price.getCharge(1));
    }

    @Test
    public void testChargingFourDayRental() throws Exception {
        assertEquals(new Euro(3.00), price.getCharge(4));
    }

    @Test
    public void testChargingFiveDaysRental() throws Exception {
        assertEquals(new Euro(4.50), price.getCharge(5));
    }
}
