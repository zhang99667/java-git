package Interface_.InterfacePolyParameter;

// 多态数组
public class InterfacePolyArr {
    public static void main(String[] args) {

        // 多态数组 -> 接口类型数组
        Usb[] usbs = new Usb[2];

        usbs[0] = new Phone();
        usbs[1] = new Camera();
        /*
        给Usb数组中，存放Phone和相机对象，Phone类还有一个特有的方法calL(),
        请遍历Usb数组，如果是Phone.对象，除了调用Usb接口定义的方法外，
        还需要调用Phone特有方法caLL
        */
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work(); // 动态绑定
            if (usbs[i] instanceof Phone) // 判断他的运行类型是 Phone
                ((Phone) usbs[i]).call();
        }
    }
}

interface Usb {
    void work();
}

class Phone implements Usb {
    public void call() {
        System.out.println("手机可以打电话！");
    }

    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
}

class Camera implements Usb {
    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}