package pl.hachiwari.IOdevice;

public class LCDDisplay implements IODevice {

    /**
     * Display message on LCD
     * @param msg message
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
