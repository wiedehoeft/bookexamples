import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    /**
     * TODO: look following text
     * Es ist aktuell nicht klar, wie genau diese Implementierung gemeint ist,
     * zur Berechnung der Gesamtkosten muss die Methode rentMovie für jeden Tag
     * aufgerufen werden, hier wird diese nur einmal aufgerufen und damit wird nur der
     * Base/Price bzw. Preisaufschlag berechnet, allerdings nicht der Gesamtpreis.
     */

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
        String statement = customer.printStatementDetail();
        assertEquals("\tBuffalo66\t2,00\n", statement);
    }

    @Test
    public void testStatementDetailForRentalLines() throws Exception {
        customer.rentMovie(buffalo66, 4);
        customer.rentMovie(jungleBook, 1);
        customer.rentMovie(pulpFiction, 4);

        String actual = customer.printStatementDetail();

        String exactlyThreeLines = "(.*\n){3}";
        assertTrue(actual.matches(exactlyThreeLines));
    }
}