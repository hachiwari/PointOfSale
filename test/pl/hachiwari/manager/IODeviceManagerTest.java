package pl.hachiwari.manager;

import org.junit.Before;
import org.junit.Test;
import pl.hachiwari.IOdevice.BarCodesScanner;
import pl.hachiwari.IOdevice.Printer;

import static org.junit.Assert.*;

public class IODeviceManagerTest {

    private IODeviceManager ioDeviceManager;

    @Before
    public void setUp() {
        ioDeviceManager = new IODeviceManager();
    }

    @Test
    public void shouldAllowToAddInputDevice() {
        BarCodesScanner barCodesScanner = new BarCodesScanner();

        ioDeviceManager.addInputDevice(IODeviceManager.SCANNER, barCodesScanner);
        assertEquals(barCodesScanner, ioDeviceManager.getInputDevice(IODeviceManager.SCANNER));
    }

    @Test
    public void shouldAllowToAddOutputDevice() {
        Printer printer = new Printer();

        ioDeviceManager.addOutputDevice(IODeviceManager.PRINTER, printer);
        assertEquals(printer, ioDeviceManager.getOutputDevice(IODeviceManager.PRINTER));
    }
}
