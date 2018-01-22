public class Movie {

    private Price price;

    public Movie(String title, Price price) {

    }

    public static Euro  getCharge(int daysRented) {
        return Price.NEWRELEASE.getCharge(daysRented);
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
