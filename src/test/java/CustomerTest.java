import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private Movie buffalo66, jungleBook, pulpFiction;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
        buffalo66 = new Movie("Buffalo66", Price.NEWRELEASE);
        jungleBook = new Movie("Das Dschungelbuch", Price.REGULAR);
        pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
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

    @Test
    public void testPrintingStatement() throws Exception {
        customer.rentMovie(buffalo66, 4);
        customer.rentMovie(jungleBook, 1);
        customer.rentMovie(pulpFiction, 4);

        buffalo66.setPrice(Price.REGULAR);

        String actual = customer.printStatement();

        String expected = "\tBuffalo 66\t3,00\n"
                + "\tDas Dschungelbuch\t1,50\n"
                + "\tPulp Fiction\t5,50\n"
                + "Gesamt: 10,00\n";

        assertEquals(expected, actual);

    }
}