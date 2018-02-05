package videostore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoStore {

  private static Map customers = new HashMap();
  private Customer customer;
  private Map<Integer, Movie> movies;
  private NumberSequence sequence;
  private List<Rental> rentals;

  public VideoStore() {
    movies = new HashMap<>();
    sequence = new NumberSequence();
    rentals = new ArrayList<>();
  }

  public int nextMovieNumber() {
    return sequence.nextNumber();
  }

  public void rentMovie(String movieTitle, int daysRented) {
    IPrice price = new Price();
    IRental rental = new Rental(movieTitle, price, daysRented);
    customer.addRental(rental);
  }

  public void printStatement() throws OutOfPaperException {
    IPrinter printer = new Printer();
    IStatement statement = new Statement(printer);
    customer.printOn(statement);
  }


  public static VideoStore bindCustomer(String name) {
    if (!customers.containsKey(name)) {
      customers.put(name, new Customer(name));
    }
    Customer customer = (Customer) customers.get(name);
    return new VideoStore(customer);
  }

  private VideoStore(Customer customer) {
    this.customer = customer;
  }

  public Movie newMovie(int number, String title, String category) throws MovieNumberAlreadyInUseException {
    if (getMovie(number) != null) {
      throw new MovieNumberAlreadyInUseException(number);
    }

    Price price = Prices.getPrice(category);
    Movie movie = new Movie(title, price);
    Integer key = new Integer(number);
    movies.put(key, movie);
    return movie;
  }

  public Movie getMovie(int number) {
    Integer key = new Integer(number);
    return movies.get(key);
  }

  public Rental addRental(int movieNumber, int daysRented) throws UnknownMovieException {
    Movie movie = getMovie(movieNumber);
    if (movie == null) {
      throw new UnknownMovieException(movieNumber);
    }
    Rental rental = new Rental(movie, daysRented);
    rentals.add(rental);
    return rental;
  }

  public int numberOfRentals() {
    return rentals.size();
  }
}