package pl.hachiwari.manager;

import pl.hachiwari.model.Product;

import java.util.LinkedList;
import java.util.List;

public class OrderManager {

    private final List<Product> order;

    public OrderManager() {
        order = new LinkedList<>();
    }

    /**
     * Add new product to the order
     * @param product product
     */
    public void addProduct(Product product) {
        getOrder().add(product);
    }

    /**
     * Returns order value
     * @return order value
     */
    public double getOrderValue() {
        return getOrder().stream().mapToDouble(product -> product.getPrice().getAmount()).sum();
    }

    /**
     * Retuns order with all product added
     * @return order
     */
    List<Product> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(Product p : getOrder()) {
            result.append(String.format("%-15s\t%.2f %s\n", p.getName(), p.getPrice().getAmount(), p.getPrice().getCurrency()));
        }
        result.append(valueToString());
        return result.toString();
    }

    public String valueToString() {
        return String.format("%-15s\t%.2f\n", "Total sum:", getOrderValue());
    }
}
