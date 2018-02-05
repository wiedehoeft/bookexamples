package videostore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

  @Test(expected = MovieNumberAlreadyInUseException.class)
  public void movieNumberAlreadyInUse() throws Exception {

    // Given
    videoStore.newMovie(1, "Rashomon", "don't care");

    //When
    videoStore.newMovie(1, "don't care", "don't care");

    //Then => Exception
  }

  @Test
  public void rentalItem() throws Exception {

    // Given
    videoStore.newMovie(1, "Koyaanisqatsi", "new release");
    videoStore.addRental(1, 1);
    videoStore.addRental(1, 3);

    //When
    List<RentalItem> items = videoStore.allRentalItems();

    //Then
    assertEquals(1, items.size());

    RentalItem rentalItem = items.get(0);
    assertEquals(1, rentalItem.movieNumber);
    assertEquals("Koyaanisqatsi", rentalItem.movieTitle);
    assertEquals(4, rentalItem.totalDaysRented);
  }
}
