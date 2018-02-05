package videostore;

public class Prices {

  public static Price getPrice(String category) {
    return "regular price".equals(category) ? Price.REGULAR : null;
  }
}
