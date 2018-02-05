package videostore;

public class MovieNumberAlreadyInUseException extends Exception {
  private int movieNumber;

  public MovieNumberAlreadyInUseException(int movieNumber) {
    this.movieNumber = movieNumber;
  }

  @Override
  public String getMessage() {
    return "unknown movie number" + movieNumber;
  }

  public int getMovieNumber() {
    return movieNumber;
  }

}
