package videostore;

@Deprecated
public class Movie {

    private String title;
    private IPrice price;
    private int number;

    public Movie(String title, IPrice price, int number) {
        this.title = title;
        this.price = price;
        this.number = number;
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

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
