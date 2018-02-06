package videostore;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Euro {

  private static final String CURRENCY_SYMBOL = "EUR ";

  private final long cents;

  public Euro(double euro) {
    this(Math.round(euro * 100));
  }

  private Euro(long cents) {
    if (cents < 0) {
      throw new IllegalArgumentException("negative amount");
    }
    this.cents = cents;
  }

  public double getAmount() {
    return cents / 100.0;
  }

  public Euro plus(Euro other) {
    return new Euro(this.cents + other.cents);
  }

  public Euro times(int factor) {
    return new Euro(cents * factor);
  }

  @Override
  public String toString() {
    return CURRENCY_SYMBOL + getAmount();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Euro euro = (Euro) o;

    return cents == euro.cents;
  }

  @Override
  public int hashCode() {
    return (int) cents;
  }

  public String format() {
    NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
    format.setMinimumFractionDigits(2);
    return format.format(getAmount());
  }

  public static Euro max(Euro a, Euro b) {
    return a.cents > b.cents ? a : b;
  }

  public static Euro parse(String text) throws ParseException {
    if (!text.startsWith(CURRENCY_SYMBOL)) {
      throw new ParseException("no currency symbol found", 0);
    }

    String number = text.substring(CURRENCY_SYMBOL.length());
    double amount = Double.parseDouble(number);
    return new Euro(amount);
  }
}
