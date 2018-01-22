public class Customer {

    private double totalCharge;

    public void rentMovie(int daysRented) {
        totalCharge += Movie.tmpCharge(daysRented).getAmount();
    }

    public double getTotalCharge() {
        return totalCharge;
    }
}
