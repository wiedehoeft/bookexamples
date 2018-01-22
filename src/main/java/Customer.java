public class Customer {

    private Euro totalCharge;

    public Customer() {
        this.totalCharge = new Euro(0.00);
    }

    public void rentMovie(int daysRented) {
        this.totalCharge = totalCharge.plus(Movie.getCharge(daysRented));
    }

    public Euro getTotalCharge() {
        return totalCharge;
    }
}
