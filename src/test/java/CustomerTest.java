import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
    }

    @Test
    public void testRentingNoMovie() throws Exception {
        assertEquals(0, customer.getTotalCharge(), 0.001);
    }

    @Test
    public void testRentingOneMovie() throws Exception {
        customer.rentMovie(1);

        assertEquals(2.0, customer.getTotalCharge(), 0.001);
    }

    @Test
    public void testRentingTwoMovies() throws Exception {
        customer.rentMovie(1);
        customer.rentMovie(2);

        assertEquals(4.0, customer.getTotalCharge(), 0.001);
    }

    @Test
    public void testRentingThreeMovies() throws Exception {
        customer.rentMovie(1);
        customer.rentMovie(2);
        customer.rentMovie(3);

        assertEquals(7.75, customer.getTotalCharge(), 0.001);
    }

    @Test
    public void testRentingFourMovies() throws Exception {
        customer.rentMovie(1);
        customer.rentMovie(2);
        customer.rentMovie(3);
        customer.rentMovie(4);

        assertEquals(13.25, customer.getTotalCharge(), 0.001);
    }
}