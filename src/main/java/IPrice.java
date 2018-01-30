public interface IPrice {

    public Euro getCharge(int daysRented);

    void printOn(IStatement statement, int daysRented) throws OutOfPaperException;
}
