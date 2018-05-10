import pl.hachiwari.IOdevice.BarCodesScanner;

public class App {

    /**
     * Run app
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        BarCodesScanner barCodesScanner = new BarCodesScanner();
        barCodesScanner.run();
    }
}
