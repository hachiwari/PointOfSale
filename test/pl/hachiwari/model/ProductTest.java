package pl.hachiwari.model;

import org.junit.Test;
import pl.hachiwari.model.Product;
import pl.hachiwari.model.Price;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void twoProductsWithTheSameValuesShouldBeEqual() {
        assertEquals(new Product(101, "Product", new Price(1.9, "PLN")),
                     new Product(101, "Product", new Price(1.9, "PLN")));
    }

    @Test
    public void productsWithDifferentBarCodeArentEqual() {
        assertNotEquals(new Product(101, "Product", new Price(1.9, "PLN")),
                        new Product(102, "Product", new Price(1.9, "PLN")));
    }

    @Test
    public void productsWithDifferentNameArentEqual() {
        assertNotEquals(new Product(101, "Product1", new Price(1.9, "PLN")),
                        new Product(101, "Product2", new Price(1.9, "PLN")));
    }

    @Test
    public void productsWithDifferentPriceArentEqual() {
        assertNotEquals(new Product(101, "Product", new Price(1.1, "PLN")),
                        new Product(101, "Product", new Price(1.9, "PLN")));
    }

    @Test
    public void productsWithTheSameNameShouldHaveTheSameHashCode() {
        assertEquals(new Product(101, "Product", new Price(1.9, "PLN")).hashCode(),
                     new Product(101, "Product", new Price(1.9, "PLN")).hashCode());
    }

    @Test
    public void productsWithDifferentNameShouldHaveDifferentHashCode() {
        assertNotEquals(new Product(101, "Product1", new Price(1.9, "PLN")).hashCode(),
                        new Product(101, "Product2", new Price(1.9, "PLN")).hashCode());
    }

    @Test
    public void productsWithDifferentBarCodeAndTheSameNamePriceShouldBeOrdered() {
        assertEquals(-1, new Product(101, "Product", new Price(1.1, "PLN")).compareTo(new Product(101, "Product", new Price(2.9, "PLN"))));
    }
}