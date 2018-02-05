package videostore;

import java.util.HashMap;
import java.util.Map;

public class Prices {

  private static Map<String, Price> prices = new HashMap<>();

  static {
    prices.put("regular price", Price.REGULAR);
    prices.put("new release", Price.NEWRELEASE);
  }

  public static Price getPrice(String category) {
    return prices.get(category);
  }
}
