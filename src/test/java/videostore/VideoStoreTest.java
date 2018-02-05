package videostore;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class VideoStoreTest {

  @Test
  public void movieHandling() throws Exception {

    // Given
    VideoStore videoStore = new VideoStore();

    //When
    Movie movie = videoStore.newMovie(1, "don't care", "don't care");

    //Then
    assertSame(movie, videoStore.getMovie(1));
    assertNotNull(movie);
  }
}
