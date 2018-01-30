package videostore;

public interface IStatement {

  public void printCustomerName(String name) throws OutOfPaperException;

  void printTotalCharge() throws OutOfPaperException;

  void printMovieTitle(String movieTitle) throws OutOfPaperException;

  void printMovieCharge(Euro charge) throws OutOfPaperException;
}
