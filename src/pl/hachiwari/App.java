package pl.hachiwari;

import pl.hachiwari.module.PointOfSale;

public class App implements Runnable {

    private Thread thread;
    private boolean running = false;

    private final PointOfSale pointOfSale;

    public App() {
        pointOfSale = new PointOfSale();
    }

    @Override
    public void run() {
        while(running) {
            pointOfSale.start();
        }

        pointOfSale.destroy();
    }

    public synchronized void start() {
        if (running) {
            return;
        }

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }

        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Run app
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        App app = new App();
        app.start();
    }
}
