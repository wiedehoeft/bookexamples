package videostore;

@Deprecated
public class Movie {

    private String title;
    private IPrice price;

    public Movie(String title, IPrice price) {
        this.title = title;
        this.price = price;
    }

    public Euro getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public void setPrice(IPrice price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
}
