import org.junit.Before;
import org.junit.Test;

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
        Euro rounded = new Euro(1.995);

        assertEquals(two, rounded);
    }

    @Test
    public void adding() throws Exception {
        Euro sum = two.plus(two);

        assertEquals(sum, new Euro(4.00));
        assertEquals(two, new Euro(2.00));
    }

    @Test
    public void testEquality() throws Exception {
        assertEquals(two, two);
        assertEquals(two, new Euro(2.00));
        assertEquals(new Euro(2.00), two);

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
        assertEquals(new Euro(14.00), result);
        assertEquals(new Euro(2.00), two);
    }

    @Test
    public void testFormatting() throws Exception {
        assertEquals("2,00", two.format());
    }
}