public class StubPrice implements IPrice {

    @Override
    public Euro getCharge(int daysRented) {
        return new Euro(2.00);
    }
}
