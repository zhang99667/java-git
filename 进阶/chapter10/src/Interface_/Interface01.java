package Interface_;

public class Interface01 {
    public static void main(String[] args) {
        // 创建手机
        // Phone 实现了 UsbInterface
        Phone phone = new Phone();
        // Camera 实现了 UsbInterface
        Camera camera = new Camera();

        // 创建计算机
        Computer computer = new Computer();
        computer.work(phone); // 把手机接入电脑
        computer.work(camera); // 把相机接入电脑
    }
}
