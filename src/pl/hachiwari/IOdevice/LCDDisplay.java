package pl.hachiwari.IOdevice;

public class LCDDisplay implements OutputDevice {

    /**
     * Display message on LCD
     * @param msg message
     */
    @Override
    public void output(String msg) {
        System.out.print(String.format("[LCD] %s", msg));
    }
}
