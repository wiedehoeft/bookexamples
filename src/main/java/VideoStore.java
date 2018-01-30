import java.util.HashMap;
import java.util.Map;

public class VideoStore {

  private static Map customers = new HashMap();
  private Customer customer;

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
}