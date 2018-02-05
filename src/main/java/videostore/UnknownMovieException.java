package videostore;

public class UnknownMovieException extends Exception {
  private int movieNumber;

  public UnknownMovieException(int movieNumber) {
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
