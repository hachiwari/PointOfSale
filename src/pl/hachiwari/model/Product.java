package pl.hachiwari.model;

/**
 * @author Tomasz Kurek
 */
public class Product implements Comparable<Product> {

    private int barCode = -1;
    private String name = "";
    private Price price = null;

    public Product(int bardCode, String name, Price price) {
        this.barCode = bardCode;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns bar-code of the product
     * @return bar-code
     */
    public int getBarCode() {
        return barCode;
    }

    /**
     * Returns name of the product
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns price of the product
     * @return price
     */
    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-15s\t%s", getName(), getPrice().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return barCode == product.barCode && (name != null ? name.equals(product.name) : product.name == null) && (price != null ? price.equals(product.price) : product.price == null);
    }

    @Override
    public int hashCode() {
        int result = barCode;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Product o) {
        if (o == null) {
            return 1;
        }

        int compare = this.getName().compareTo(o.getName());

        if (compare != 0) {
            return compare;
        }

        compare = this.getPrice().compareTo(o.getPrice());

        if (compare != 0) {
            return compare;
        }

        return Double.compare(this.getBarCode(), o.getBarCode());
    }
}
