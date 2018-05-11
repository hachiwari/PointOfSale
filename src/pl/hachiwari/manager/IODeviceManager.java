package pl.hachiwari.manager;

import pl.hachiwari.IOdevice.InputDevice;
import pl.hachiwari.IOdevice.OutputDevice;

import java.util.HashMap;
import java.util.Map;

public class IODeviceManager {

    public static final int LCD = 0;
    public static final int PRINTER = 1;
    public static final int SCANNER = 2;

    private final Map<Integer, InputDevice> inputDevices;
    private final Map<Integer, OutputDevice> outputDevices;

    public IODeviceManager() {
        inputDevices = new HashMap<>();
        outputDevices = new HashMap<>();
    }

    public void addInputDevice(Integer typeDevice, InputDevice inputDevice) {
        if (inputDevice == null) {
            return;
        }

        inputDevices.put(typeDevice, inputDevice);
    }

    public void addOutputDevice(Integer typeDevice, OutputDevice outputDevice) {
        if (outputDevice == null) {
            return;
        }

        outputDevices.put(typeDevice, outputDevice);
    }

    public InputDevice getInputDevice(Integer typeDevice) {
        return inputDevices.get(typeDevice);
    }

    public OutputDevice getOutputDevice(Integer typeDevice) {
        return outputDevices.get(typeDevice);
    }
}
