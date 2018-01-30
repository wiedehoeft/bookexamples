package videostore;

public class Statement implements IStatement {


  private final IPrinter printer;
  private Euro total = new Euro(0.0);

  public Statement(IPrinter printer) {
    this.printer = printer;
  }

  @Override
  public void printCustomerName(String name) throws OutOfPaperException {
    printer.print("videostore.Rental records for " + name);
    printer.crlf();
  }

  @Override
  public void printTotalCharge() throws OutOfPaperException {
    printer.print("Amount owed is " + total.format());
    printer.crlf();
    printer.cutPaper();

  }

  @Override
  public void printMovieTitle(String movieTitle) throws OutOfPaperException {
    printer.tab();
    printer.print(movieTitle);
  }

  @Override
  public void printMovieCharge(Euro charge) throws OutOfPaperException {
    printer.tab();
    printer.print(charge.format());
    printer.crlf();
    total = total.plus(charge);
  }
}
