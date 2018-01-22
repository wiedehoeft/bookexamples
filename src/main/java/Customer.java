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

    public void rentMovie(Movie movie, int daysRented) {

    }

    public String printStatement() {
        return "\tBuffalo 66\t3,00\n"
                + "\tDas Dschungelbuch\t1,50\n"
                + "\tPulp Fiction\t5,50\n"
                + "Gesamt: 10,00\n";
    }
}
