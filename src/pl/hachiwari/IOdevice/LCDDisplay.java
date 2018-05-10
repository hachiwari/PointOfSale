package pl.hachiwari.IOdevice;

public class LCDDisplay implements IODevice {

    /**
     * Display message on LCD
     * @param msg message
     */
    @Override
    public void print(String msg) {
        System.out.print(String.format("[LCD] %s", msg));
    }

    /**
     * Display message on LCD
     * @param msg message
     */
    @Override
    public void println(String msg) {
        System.out.println(String.format("[LCD] %s", msg));
    }
}
