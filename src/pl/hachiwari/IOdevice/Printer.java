package pl.hachiwari.IOdevice;

public class Printer implements IODevice {

    /**
     * Print message
     * @param msg message
     */
    @Override
    public void print(String msg) {
        System.out.print(String.format("[Printer]\n%s", msg));
    }

    /**
     * Display message on LCD
     * @param msg message
     */
    @Override
    public void println(String msg) {
        System.out.println(String.format("[Printer]\n%s", msg));
    }
}
