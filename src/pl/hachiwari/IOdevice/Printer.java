package pl.hachiwari.IOdevice;

public class Printer implements OutputDevice {

    /**
     * Print message
     * @param msg message
     */
    @Override
    public void output(String msg) {
        System.out.print(String.format("[Printer]\n%s", msg));
    }
}
