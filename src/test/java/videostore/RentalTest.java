package videostore;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    @Test
    public void testUsingMovie() throws Exception {
        Movie movie = new Movie("Blow-Up", Price.NEWRELEASE, 1);
        Rental rental = new Rental(movie, 2);
        Assert.assertEquals(new Euro(2.00), rental.getCharge());
    }
}
