package pl.hachiwari.IOdevice;

import pl.hachiwari.manager.PointOfSale;
import pl.hachiwari.manager.ProductManager;
import pl.hachiwari.model.Product;

import java.util.Scanner;

/**
 * @author Tomasz Kurek
 */
public class BarCodesScanner {

    private final ProductManager productManager = new ProductManager();
    private final PointOfSale pointOfSale = new PointOfSale();

    /**
     * Run point of sale application
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String enterLine;
        Boolean exit = false;

        do {
            System.out.print("Enter bar-code: ");
            enterLine = scanner.nextLine();

            if (enterLine.equals("exit")) {
                exit = true;
                exit();
            } else {
                scanBarCode(enterLine);
            }
        } while(!exit);
    }

    /**
     * Scan new bar-code
     * @param enterBarCode new bar-code
     */
    private void scanBarCode(String enterBarCode) {
        Product product;

        if (enterBarCode.isEmpty()) {
            System.out.println("Invalid bar-code");
            return;
        }

        try {
            if ((product = productManager.getProduct(Integer.parseInt(enterBarCode))) != null) {
                pointOfSale.addProduct(product);
                System.out.println(product.toString());
            } else {
                System.out.println("Product not found");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid bar-code");
        }
    }

    /**
     * Show bill with total sum
     */
    private void exit() {
        System.out.println(pointOfSale.toString());
    }

}
