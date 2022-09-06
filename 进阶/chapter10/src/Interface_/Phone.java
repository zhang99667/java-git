package Interface_;


// Phone 类 实现 USBInterface 接口
// 解读
// 1. 即 Phone 类需要实现 UsbInterface 接口 规定 / 声明

public class Phone implements UsbInterface {
    @Override
    public void start() {
        System.out.println("phone started...");
    }

    @Override
    public void stop() {
        System.out.println("phone stopped...");
    }
}
