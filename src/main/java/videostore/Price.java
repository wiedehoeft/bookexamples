package videostore;

public class Price implements IPrice {

  @Override
  public void printOn(IStatement statement, int daysRented) {
    Euro flat = new Euro(1.50);
    Euro incremental = new Euro(0.00);

    if (daysRented > 1) {
      incremental = new Euro(1.50).times(daysRented - 2);
    }

    statement.printMovieCharge(Euro.max(flat, incremental));
  }
}
