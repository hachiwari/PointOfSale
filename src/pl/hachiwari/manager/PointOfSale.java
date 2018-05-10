package pl.hachiwari.manager;
import pl.hachiwari.model.Product;

import java.util.LinkedList;

/**
 * @author Tomasz Kurek
 */
public class PointOfSale {

    private final LinkedList<Product> order = new LinkedList<>();

    /**
     * Add new product to the order
     * @param product product
     */
    public void addProduct(Product product) {
        order.add(product);
    }

    public double getOrderValue() {
        double orderValue = 0;

        for(Product p : order) {
            orderValue += p.getPrice().getAmount();
        }

        return orderValue;
    }

    /**
     * Retuns order with all product added
     * @return order
     */
    LinkedList<Product> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(Product p : order) {
            result.append(String.format("%-15s\t%.2f %s\n", p.getName(), p.getPrice().getAmount(), p.getPrice().getCurrency()));
        }
        result.append(String.format("%-15s\t%.2f", "Total sum:", getOrderValue()));
        return result.toString();
    }
}
