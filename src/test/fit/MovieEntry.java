import fit.ColumnFixture;
import videostore.MovieNumberAlreadyInUseException;
import videostore.VideoStore;

public class MovieEntry extends ColumnFixture {
  private VideoStore store = SystemUnderTest.instance();

  public int number;
  public String title;
  public String category;

  public boolean isValid() {
    try {
      store.newMovie(number, title, category);
      return true;
    } catch (MovieNumberAlreadyInUseException e) {
      return false;
    }
  }
}
