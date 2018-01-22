import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
    }

    @Test
    public void testRentingNoMovie() throws Exception {
        assertEquals(new Euro(0), customer.getTotalCharge());
    }

    @Test
    public void testRentingOneMovie() throws Exception {
        customer.rentMovie(1);

        assertEquals(new Euro(2.00), customer.getTotalCharge());
    }

    @Test
    public void testRentingTwoMovies() throws Exception {
        customer.rentMovie(1);
        customer.rentMovie(2);

        assertEquals(new Euro(4.00), customer.getTotalCharge());
    }

    @Test
    public void testRentingThreeMovies() throws Exception {
        customer.rentMovie(1);
        customer.rentMovie(2);
        customer.rentMovie(3);

        assertEquals(new Euro(7.75), customer.getTotalCharge());
    }

    @Test
    public void testRentingFourMovies() throws Exception {
        customer.rentMovie(1);
        customer.rentMovie(2);
        customer.rentMovie(3);
        customer.rentMovie(4);

        assertEquals(new Euro(13.25), customer.getTotalCharge());
    }
}