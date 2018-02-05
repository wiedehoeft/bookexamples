package videostore;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void usingNewReleasePrice() throws Exception {
        Movie movie = new Movie("Fight Club", Price.NEWRELEASE, 1);
        Assert.assertEquals(new Euro(3.75), movie.getCharge(3));
    }

    @Test
    public void testUsingRegularPrice() throws Exception {
        Movie movie = new Movie("Brazil", Price.REGULAR, 1);
        Assert.assertEquals(new Euro(1.50), movie.getCharge(3));
    }

    @Test
    public void testSettingNewPrice() throws Exception {
        Movie movie = new Movie("Fight Club", Price.NEWRELEASE, 1);
        movie.setPrice(Price.REGULAR);
        Assert.assertEquals(new Euro(1.50), movie.getCharge(3));
    }

    /**
     * Test adds no extra functionality, it just demonstrates stub objects.
     */
    @Test
    public void testUsingStubPrice() throws Exception {
        Movie movie = new Movie("Brazil", new StubPrice(), 1);
        Assert.assertEquals(new Euro(2.00), movie.getCharge(3));
    }
}
