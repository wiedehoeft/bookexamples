import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTest implements IPrinter {

    private Customer customer;
    private Movie buffalo66, jungleBook, pulpFiction;
    private String printerOutput;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
        buffalo66 = new Movie("Buffalo66", new StubPrice());
        jungleBook = new Movie("Das Dschungelbuch", Price.REGULAR);
        pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
        printerOutput = "";
    }

    @Test
    public void testRentingNoMovie() throws Exception {
        assertEquals(new Euro(0), customer.getTotalCharge());
    }

    @Test
    public void testRentingThreeMovies() throws Exception {
        customer.rentMovie(pulpFiction, 1);
        customer.rentMovie(pulpFiction, 2);
        customer.rentMovie(pulpFiction, 3);

        assertEquals(new Euro(7.75), customer.getTotalCharge());
    }

    @Test
    public void testRentingFourMovies() throws Exception {
        customer.rentMovie(pulpFiction, 1);
        customer.rentMovie(pulpFiction, 2);
        customer.rentMovie(pulpFiction, 3);
        customer.rentMovie(pulpFiction, 4);

        assertEquals(new Euro(13.25), customer.getTotalCharge());
    }

    @Test
    public void testPrintingStatementFooterWithOneMovie() throws Exception {
        customer.rentMovie(pulpFiction, 1);

        String actual = customer.printStatementFooter();
        String expected = "Gesamt: 2,00\n";

        assertEquals(expected, actual);
    }

    @Test
    public void testStatementDetailForRentals() throws Exception {
        customer.rentMovie(buffalo66, 1);
        customer.printStatementDetail(this);
        assertEquals("\tBuffalo66\t2,00\n", printerOutput);
    }

    @Test
    public void testStatementDetailForRentalLines() throws Exception {
        customer.rentMovie(buffalo66, 4);
        customer.rentMovie(jungleBook, 1);
        customer.rentMovie(pulpFiction, 4);

        customer.printStatementDetail(this);

        String exactlyThreeLines = "(.*\n){3}";
        assertTrue(printerOutput.matches(exactlyThreeLines));
    }

    @Override
    public void print(String line) {
        printerOutput += line;
    }
}