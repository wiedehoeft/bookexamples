import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegularPriceTest {

    private RegularPrice price;

    @Before
    public void setUp() throws Exception {
        price = new RegularPrice();
    }

    @Test
    public void testChargingOneDayRental() throws Exception {
        Assert.assertEquals(new Euro(1.50), price.getCharge(1));
    }

    @Test
    public void testChargingFourDayRental() throws Exception {
        Assert.assertEquals(new Euro(3.00), price.getCharge(4));
    }
}
