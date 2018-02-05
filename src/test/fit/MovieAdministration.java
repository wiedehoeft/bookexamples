import fit.Fixture;
import videostore.NumberSequence;

public class MovieAdministration extends Fixture {
  private NumberSequence sequence = new NumberSequence();
  private int movieNumber;

  public void newMovie() {
    movieNumber = sequence.nextNumber();
  }

  public void save() {

  }

  public int movieNumber() {
    return movieNumber;
  }

  public void movieTitle(String title) {

  }

  public void priceCategory(String category) {

  }
}
