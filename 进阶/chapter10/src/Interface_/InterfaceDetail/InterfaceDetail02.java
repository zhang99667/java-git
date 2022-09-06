package Interface_.InterfaceDetail;

public class InterfaceDetail02 {
    public static void main(String[] args) {
        // prove
        // 接口中的属性 是 public static final
        System.out.println(IB.n1); // 说明 n1 就是 static

        // IB.n1 = 30;  // Cannot assign a value to final variable 'n1' -> 说明 n1 是 final


    }
}

interface IB {
    int n1 = 100; // 等价 public static final int n1 = 10;

    void hi();
}

interface IC {
    void say();
}

// 5. 一个类可以同时实现多个接口
class Pig implements IB, IC {

    @Override
    public void hi() {
        System.out.println("hi...");
    }

    @Override
    public void say() {
        System.out.println("say...");
    }
}


// 一个接口不能继承其它的类，但是可以继承多个别的接口
interface ID extends IB, IC { }
