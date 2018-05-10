package pl.hachiwari.manager;

import org.junit.Before;
import org.junit.Test;

import pl.hachiwari.model.Price;
import pl.hachiwari.model.Product;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class PointOfSaleTest {

    private static final double DELTA = 0.01;

    private PointOfSale pointOfSale;
    private Product product;

    @Before
    public void setUp() {
        ProductManager productManager = new ProductManager();
        pointOfSale = new PointOfSale();
        product = productManager.getProduct(100);
    }

    @Test
    public void shouldAllowToAddItemToOrder() {
        LinkedList<Product> products = createOrder(product);

        pointOfSale.addProduct(product);
        assertEquals(products, pointOfSale.getOrder());
    }

    @Test
    public void shouldAllowToAddTheSameItemTwice() {
        LinkedList<Product> products = createOrder(product, product);

        pointOfSale.addProduct(product);
        pointOfSale.addProduct(product);

        assertEquals(products, pointOfSale.getOrder());
    }

    @Test
    public void shouldComputeOrderValue() {
        pointOfSale.addProduct(product);
        assertEquals(product.getPrice().getAmount(), pointOfSale.getOrderValue(), DELTA);
    }

    @Test
    public void shouldPrintOrder() {
        pointOfSale.addProduct(product);

        String value = String.format("%-15s\t%.2f %s\n", product.getName(), product.getPrice().getAmount(), product.getPrice().getCurrency()) +
                String.format("%-15s\t%.2f", "Total sum:", pointOfSale.getOrderValue());

        assertEquals(value, pointOfSale.toString());
    }

    @Test
    public void shouldComputeOrderWithManyProductsValue() {
        Product candy = new Product(112, "Candy", new Price(1.0, "PLN"));
        pointOfSale.addProduct(candy);
        pointOfSale.addProduct(product);
        pointOfSale.addProduct(product);

        double totalSum = candy.getPrice().getAmount() + product.getPrice().getAmount() * 2;

        assertEquals(totalSum, pointOfSale.getOrderValue(), DELTA);
    }

    private static LinkedList<Product> createOrder(Object ... list) {
        LinkedList<Product> result = new LinkedList<>();

        for (Object o : list) {
            result.add((Product) o);
        }

        return result;
    }
}