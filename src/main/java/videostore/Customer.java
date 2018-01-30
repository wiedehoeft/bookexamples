package videostore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private List<Rental> rentals = new ArrayList<>();
  private List<IRental> iRentals = new ArrayList<>();
  private String name;

  public Customer(String name) {
    this.name = name;
  }

  @Deprecated
  public Euro getTotalCharge() {
    Euro result = new Euro(0.00);

    for (Rental rental : rentals) {
      result = result.plus(rental.getCharge());
    }
    return result;
  }

  public void rentMovie(Movie movie, int daysRented) {
    rentals.add(new Rental(movie, daysRented));
  }

  @Deprecated
  public String printStatementFooter() {
    return "Gesamt: " + getTotalCharge().format() + "\n";
  }

  @Deprecated
  public void printStatementDetail(IPrinter printer) throws OutOfPaperException {
    for (Rental rental : rentals) {
      printer.tab();
      printer.print(rental.getMovieTitle());
      printer.tab();
      printer.print(rental.getCharge().format());
      printer.crlf();
    }
    printer.cutPaper();
  }

  public void addRental(IRental controlRental) {
    iRentals.add(controlRental);
  }

  public void printOn(IStatement statement) throws OutOfPaperException {
    statement.printCustomerName(name);
    printRentalsOn(statement);
    statement.printTotalCharge();
  }

  private void printRentalsOn(IStatement statement) throws OutOfPaperException {
    for (IRental rental : iRentals) {
      rental.printOn(statement);
    }
  }
}
