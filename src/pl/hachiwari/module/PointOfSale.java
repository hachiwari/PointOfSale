package pl.hachiwari.module;
import pl.hachiwari.IOdevice.BarCodesScanner;
import pl.hachiwari.IOdevice.LCDDisplay;
import pl.hachiwari.IOdevice.Printer;
import pl.hachiwari.manager.OrderManager;
import pl.hachiwari.manager.ProductManager;
import pl.hachiwari.manager.IODeviceManager;
import pl.hachiwari.model.Product;

/**
 * @author Tomasz Kurek
 */
public class PointOfSale {

    private final OrderManager orderManager;
    private final IODeviceManager ioDeviceManager;
    private final ProductManager productManager;

    private boolean exit = false;

    public PointOfSale() {
        orderManager = new OrderManager();
        ioDeviceManager = new IODeviceManager();
        productManager = new ProductManager();

        ioDeviceManager.addOutputDevice(IODeviceManager.LCD, new LCDDisplay());
        ioDeviceManager.addOutputDevice(IODeviceManager.PRINTER, new Printer());

        ioDeviceManager.addInputDevice(IODeviceManager.SCANNER, new BarCodesScanner());
    }

    public void start() {
        do {
            BarCodesScanner barCodesScanner = (BarCodesScanner) ioDeviceManager.getInputDevice(IODeviceManager.SCANNER);
            String inputBarOcde = barCodesScanner.input();

            if (inputBarOcde.equals("exit")) {
                exit = true;
                exit();
            } else {
                checkBarCode(inputBarOcde);
            }

        } while(!exit);
    }

    public void destroy() {
        BarCodesScanner barCodesScanner = (BarCodesScanner) ioDeviceManager.getInputDevice(IODeviceManager.SCANNER);
        barCodesScanner.closeScanner();
    }

    private void checkBarCode(String inputBarCode) {
        LCDDisplay lcdDisplay = (LCDDisplay) ioDeviceManager.getOutputDevice(IODeviceManager.LCD);

        if (inputBarCode.isEmpty()) {
            lcdDisplay.output("Invalid bar-code\n");
        } else {
            try {
                Product product;
                if ((product = productManager.getProduct(Integer.parseInt(inputBarCode))) != null) {
                    orderManager.addProduct(product);
                    lcdDisplay.output(product.toString());
                } else {
                    lcdDisplay.output("Product not found\n");
                }
            } catch (NumberFormatException e) {
                lcdDisplay.output("Invalid bar-code\n");
            }
        }
    }

    private void exit() {
        Printer printer = (Printer) ioDeviceManager.getOutputDevice(IODeviceManager.PRINTER);
        LCDDisplay lcdDisplay = (LCDDisplay) ioDeviceManager.getOutputDevice((IODeviceManager.LCD));

        printer.output(orderManager.toString());
        lcdDisplay.output(orderManager.valueToString());
    }
}
