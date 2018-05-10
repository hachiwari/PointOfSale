package pl.hachiwari.IOdevice;

public class Printer implements IODevice {

    /**
     * Print message
     * @param msg message
     */
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
