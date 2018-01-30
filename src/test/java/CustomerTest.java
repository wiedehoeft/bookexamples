import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CustomerTest implements IPrinter {

    private Customer customer;
    private Movie buffalo66, jungleBook, pulpFiction;
    private String printerOutput;
    private CustomerTest customerTest;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Hugo");
        buffalo66 = new Movie("Buffalo66", new StubPrice());
        jungleBook = new Movie("Das Dschungelbuch", Price.REGULAR);
        pulpFiction = new Movie("Pulp Fiction", Price.NEWRELEASE);
        printerOutput = "";
        customerTest = Mockito.spy(this);
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

        customer.printStatementDetail(customerTest);

        verify(customerTest, times(6)).tab();
        verify(customerTest, times(3)).crlf();
        verify(customerTest, times(1)).cutPaper();
    }

    @Override
    public void print(String output) throws OutOfPaperException {
        printerOutput += output;
    }

    @Override
    public void tab() throws OutOfPaperException {
        printerOutput += "\t";

    }

    @Override
    public void crlf() throws OutOfPaperException {
        printerOutput += "\n";

    }

    @Override
    public void cutPaper() throws OutOfPaperException {

    }
}