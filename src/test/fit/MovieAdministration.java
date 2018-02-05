import fit.Fixture;
import videostore.Movie;
import videostore.NumberSequence;
import videostore.Price;
import videostore.VideoStore;

import java.util.HashMap;
import java.util.Map;

import static videostore.MovieAdministration.getPrice;

public class MovieAdministration extends Fixture {
  private int movieNumber;
  private String movieTitle;
  private String priceCategory;
  private Map<Integer, Movie> movies = new HashMap<>();

  private VideoStore store = new VideoStore();

  public void newMovie() {
    movieNumber = store.nextMovieNumber();
  }

  public void save() {
    Price price = getPrice(priceCategory);
    Movie movie = new Movie(movieTitle, price);
    Integer key = new Integer(movieNumber);
    movies.put(key, movie);

    store.newMovie(movieNumber, movieTitle, priceCategory);
  }

  public int movieNumber() {
    return movieNumber;
  }

  public void movieTitle(String title) {
    movieTitle = title;
  }

  public void priceCategory(String category) {
    priceCategory = category;
  }
}
