public class Price {

    private Euro basePrice = new Euro(1.50);
    private Euro pricePerDay = new Euro(1.50);
    private int daysDiscounted = 3;

    public Price(Euro basePrice, Euro pricePerDay, int daysDiscounted) {
        this.basePrice = basePrice;
        this.pricePerDay = pricePerDay;
        this.daysDiscounted = daysDiscounted;
    }

    public Euro getCharge(int daysRented) {

        if (daysRented <= daysDiscounted) {
            return basePrice;
        }

        int additionalDays = daysRented - daysDiscounted;

        return basePrice.plus(pricePerDay.times(additionalDays));
    }
}
