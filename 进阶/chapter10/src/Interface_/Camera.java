package Interface_;

public class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("camera started...");
    }

    @Override
    public void stop() {
        System.out.println("camera stopped...");
    }
}
