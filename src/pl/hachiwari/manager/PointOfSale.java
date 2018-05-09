package pl.hachiwari.manager;
import pl.hachiwari.model.Product;

import java.util.LinkedList;

/**
 * @author Tomasz Kurek
 */
public class PointOfSale {

    public static ProductManager productManager = new ProductManager();
    private LinkedList<Product> order = new LinkedList<>();

    /**
     * Add new product to the bill
     * @param barCode bar-code of the product
     * @return product
     */
    public Product addProduct(int barCode) {
        Product product;

        if ((product = productManager.getProduct(barCode)) != null) {
            order.add(product);
        }

        return product;
    }

    public double getOrderValue() {
        double orderValue = 0;

        for(Product p : order) {
            orderValue += p.getPrice().getAmount();
        }

        return orderValue;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for(Product p : order) {
            result.append(String.format("%s\t\t%.2f %s\n", p.getName(), p.getPrice().getAmount(), p.getPrice().getCurrency()));
        }
        result.append(String.format("Total sum:\t\t%.2f", getOrderValue()));
        return result.toString();
    }
}
