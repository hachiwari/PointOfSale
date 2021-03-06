package pl.hachiwari.manager;

import pl.hachiwari.model.Price;
import pl.hachiwari.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author Tomasz Kurek
 */
public class ProductManager {

    private final LinkedList<Product> productList = new LinkedList<>();

    public ProductManager() {
        initProduct();
    }

    /**
     * Initialization of all products from database
     */
    private void initProduct() {
        String currentLine;
        StringTokenizer tokenizer;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("db_product.csv"));

            while((currentLine = bufferedReader.readLine()) != null) {
                tokenizer = new StringTokenizer(currentLine, ",");

                while (tokenizer.hasMoreTokens()) {
                    int barCode = Integer.parseInt(tokenizer.nextToken());
                    String name = tokenizer.nextToken();
                    double amount = Double.parseDouble(tokenizer.nextToken());
                    String currency = tokenizer.nextToken();

                    productList.add(new Product(barCode, name, new Price(amount, currency)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Returns the product with the specified bar-code
     * @param barCode bar-code of the product
     * @return product
     */
    public Product getProduct(int barCode) {
        return productList.stream().filter(product -> product.getBarCode() == barCode).findAny().orElse(null);
    }
}
