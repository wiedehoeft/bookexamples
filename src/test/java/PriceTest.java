import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriceTest {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new Euro(2.00), 1},
                {new Euro(3.75), 3},
                {new Euro(5.50), 4}
        });
    }

    private Euro priceExpected;
    private int daysRented;

    public PriceTest(Euro priceExpected, int daysRented) {
        this.priceExpected = priceExpected;
        this.daysRented = daysRented;
    }

    @Test
    public void test() {
        assertEquals(priceExpected, Price.NEWRELEASE.getCharge(daysRented));
    }
}