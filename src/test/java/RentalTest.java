import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void testUsingMovie() throws Exception {
        Movie movie = new Movie("Blow-Up", Price.NEWRELEASE);
        Rental rental = new Rental(movie, 2);
        assertEquals(new Euro(2.00), rental.getCharge());
    }
}
