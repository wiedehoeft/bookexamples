package videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private List<IRental> rentals = new ArrayList<>();
  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(IRental controlRental) {
    rentals.add(controlRental);
  }

  public void printOn(IStatement statement) {
    statement.printCustomerName(name);
    printRentalsOn(statement);
    statement.printTotalCharge();
  }

  private void printRentalsOn(IStatement statement) {
    for (IRental rental : rentals) {
      rental.printOn(statement);
    }
  }
}
