package pl.hachiwari.manager;

import pl.hachiwari.model.Product;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class PointOfSaleTest {



    private static LinkedList<Product> createOrder(Object ... list) {
        LinkedList<Product> result = new LinkedList<>();

        for (Object o : list) {
            result.add((Product) o);
        }

        return result;
    }
}