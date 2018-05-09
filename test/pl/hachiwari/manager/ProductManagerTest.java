package pl.hachiwari.manager;

import org.junit.Before;
import org.junit.Test;
import pl.hachiwari.model.Product;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ProductManagerTest {

    private ProductManager productManager;

    @Before
    public void setUp() {
        productManager = new ProductManager();
    }

}
