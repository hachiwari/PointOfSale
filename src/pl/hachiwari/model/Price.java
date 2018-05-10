package pl.hachiwari.model;

/**
 * @author Tomasz Kurek
 */
public class Price implements Comparable<Price> {
    private double amount;
    private String currency;

    public Price(double amount, String currency){
        if (amount < 0) {
            throw new IllegalArgumentException(String.format("Illegal amount %.2f.", amount));
        }

        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Returns amount of the price
     * @return amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns currency of the price
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency.toUpperCase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        return Double.compare(price.amount, amount) == 0 && (currency != null ? currency.equals(price.currency) : price.currency == null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Price o) {
        if (o == null) {
            return 1;
        }

        int compare = this.getCurrency().compareTo(o.getCurrency());

        if (compare != 0) {
            return compare;
        }

        return Double.compare(this.getAmount(), o.getAmount());
    }
}
