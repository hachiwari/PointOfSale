package pl.hachiwari.manager;

import pl.hachiwari.IOdevice.BarCodesScanner;
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
            BarCodesScanner.lcdDisplay.println(String.format("Error read products from database! [%s]", e.getMessage()));
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
        Product product;

        for (Product aProductList : productList) {
            product = aProductList;
            if (product.getBarCode() == barCode) {
                return product;
            }
        }

        return null;
    }
}
