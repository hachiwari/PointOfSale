package pl.hachiwari.IOdevice;

import java.util.Scanner;

/**
 * @author Tomasz Kurek
 */
public class BarCodesScanner implements InputDevice {

    private final Scanner scanner;

    public BarCodesScanner() {
        scanner = new Scanner(System.in);
    }

    /**
     * Close scanner
     */
    public void closeScanner() {
        scanner.close();
    }

    /**
     * Returns input
     * @return input
     */
    @Override
    public String input() {
        return scanner.nextLine();
    }
}
