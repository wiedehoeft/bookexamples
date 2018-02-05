package videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class VideoStoreTest {

  private VideoStore videoStore;

  @Before
  public void setUp() throws Exception {
    videoStore = new VideoStore();
  }

  @Test
  public void movieHandling() throws Exception {

    //When
    Movie movie = videoStore.newMovie(1, "don't care", "don't care");

    //Then
    assertSame(movie, videoStore.getMovie(1));
    assertNotNull(movie);
  }

  @Test
  public void rentHandling() throws Exception {

    //When
    videoStore.newMovie(7, "Seven Samurai", "regular price");
    Rental rental = videoStore.addRental(7, 42);

    //Then
    assertEquals("Seven Samurai", rental.getMovieTitle());
    assertEquals(1, videoStore.numberOfRentals());
  }

  @Test(expected = UnknownMovieException.class)
  public void unknownMovie() throws Exception {

    //When
    videoStore.addRental(42, 7);

    //Then => exception thrown
  }
}
