import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void usingNewReleasePrice() throws Exception {
        assertEquals(new Euro(3.75), Movie.getCharge(3));
    }
}
