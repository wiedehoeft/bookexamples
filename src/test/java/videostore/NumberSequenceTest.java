package videostore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberSequenceTest {

  @Test
  public void getCurrentMovieSequenceForNewMovie() throws Exception {

    // Given
    NumberSequence numberSequence = new NumberSequence();

    //Expect
    assertEquals(1, numberSequence.nextNumber());
    assertEquals(2, numberSequence.nextNumber());
    assertEquals(3, numberSequence.nextNumber());
  }
}
