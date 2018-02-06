import fit.Fixture;
import fit.Parse;
import videostore.Movie;
import videostore.VideoStore;

import java.util.List;

public class MovieSearch extends Fixture {

  private VideoStore store = SystemUnderTest.instance();

  @Override
  public void doCell(Parse cell, int columnNumber) {
    String movieTitle = cell.text();

    if (store.hasMovie(movieTitle)) {
      right(cell);
    } else {
      wrong(cell);
    }
  }
}
