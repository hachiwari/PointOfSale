package pl.hachiwari.manager;


import org.junit.Before;
import org.junit.Test;
import pl.hachiwari.model.Price;
import pl.hachiwari.model.Product;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class OrderManagerTest {

    private static final double DELTA = 0.01;

    private OrderManager orderManager;
    private Product product;

    @Before
    public void setUp() {
        ProductManager productManager = new ProductManager();
        orderManager = new OrderManager();
        product = productManager.getProduct(100);
    }

    @Test
    public void shouldAllowToAddItemToOrder() {
        LinkedList<Product> products = createOrder(product);

        orderManager.addProduct(product);
        assertEquals(products, orderManager.getOrder());
    }

    @Test
    public void shouldAllowToAddTheSameItemTwice() {
        LinkedList<Product> products = createOrder(product, product);

        orderManager.addProduct(product);
        orderManager.addProduct(product);

        assertEquals(products, orderManager.getOrder());
    }

    @Test
    public void shouldComputeOrderValue() {
        orderManager.addProduct(product);
        assertEquals(product.getPrice().getAmount(), orderManager.getOrderValue(), DELTA);
    }

    @Test
    public void shouldPrintOrder() {
        orderManager.addProduct(product);

        String value = String.format("%-15s\t%.2f %s\n", product.getName(), product.getPrice().getAmount(), product.getPrice().getCurrency()) +
                String.format("%-15s\t%.2f\n", "Total sum:", orderManager.getOrderValue());

        assertEquals(value, orderManager.toString());
    }

    @Test
    public void shouldComputeOrderWithManyProductsValue() {
        Product candy = new Product(112, "Candy", new Price(1.0, "PLN"));
        orderManager.addProduct(candy);
        orderManager.addProduct(product);
        orderManager.addProduct(product);

        double totalSum = candy.getPrice().getAmount() + product.getPrice().getAmount() * 2;

        assertEquals(totalSum, orderManager.getOrderValue(), DELTA);
    }

    private static LinkedList<Product> createOrder(Object ... list) {
        LinkedList<Product> result = new LinkedList<>();

        for (Object o : list) {
            result.add((Product) o);
        }

        return result;
    }
}
