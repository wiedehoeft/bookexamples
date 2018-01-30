package videostore;

public class Price implements IPrice {

    public static final Price NEWRELEASE = new Price(new Euro(2.00), new Euro(1.75), 2);
    public static final Price REGULAR = new Price(new Euro(1.50), new Euro(1.50), 3);

    private Euro basePrice;
    private Euro pricePerDay;
    private int daysDiscounted;

  public Price() {
  }

  @Deprecated
  public Price(Euro basePrice, Euro pricePerDay, int daysDiscounted) {
        this.basePrice = basePrice;
        this.pricePerDay = pricePerDay;
        this.daysDiscounted = daysDiscounted;
    }

    @Deprecated
    public Euro getCharge(int daysRented) {

        if (daysRented <= daysDiscounted) {
            return basePrice;
        }

        int additionalDays = daysRented - daysDiscounted;

        return basePrice.plus(pricePerDay.times(additionalDays));
    }

    @Override
    public void printOn(IStatement statement, int daysRented) throws OutOfPaperException {
      Euro flat = new Euro(1.50);
      Euro incremental = new Euro(1.50).times(daysRented - 2);
      statement.printMovieCharge(Euro.max(flat, incremental));
    }
}
