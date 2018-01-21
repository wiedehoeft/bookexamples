public class Euro {

    private final long cents;

    public Euro(double euro) {
        if (euro < 0) {
            throw new IllegalArgumentException("negative amount");
        }
        cents = Math.round(euro * 100.0);
    }

    private Euro(long cents) {
        this.cents = cents;
    }

    public double getAmount() {
        return cents / 100.0;
    }

    public Euro add(Euro other) {
        return new Euro(this.cents + other.cents);
    }

    @Override
    public String toString() {
        return "EUR" + getAmount();
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
}
