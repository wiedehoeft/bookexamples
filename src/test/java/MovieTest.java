import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void usingNewReleasePrice() throws Exception {
        Movie movie = new Movie("Fight Club", Price.NEWRELEASE);
        assertEquals(new Euro(3.75), movie.getCharge(3));
    }

    @Test
    public void testUsingRegularPrice() throws Exception {
        Movie movie = new Movie("Brazil", Price.REGULAR);
        assertEquals(new Euro(1.50), movie.getCharge(3));
    }

    @Test
    public void testSettingNewPrice() throws Exception {
        Movie movie = new Movie("Fight Club", Price.NEWRELEASE);
        movie.setPrice(Price.REGULAR);
        assertEquals(new Euro(1.50), movie.getCharge(3));
    }

    /**
     * Test adds no extra functionality, it just demonstrates stub objects.
     */
    @Test
    public void testUsingStubPrice() throws Exception {
        Movie movie = new Movie("Brazil", new StubPrice());
        assertEquals(new Euro(2.00), movie.getCharge(3));
    }
}
