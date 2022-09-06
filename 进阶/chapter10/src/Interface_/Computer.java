package Interface_;

public class Computer {
    // 编写一个方法，计算机工作

    // 1. 实现了 UsbInterface 接口的类的对象实例
    public void work(UsbInterface usbInterface){
        usbInterface.start();
        usbInterface.stop();
    }
}