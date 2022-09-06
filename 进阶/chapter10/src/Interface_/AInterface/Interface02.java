package Interface_.AInterface;

public class Interface02 {
    public static void main(String[] args) {
        A a = new A();
        a.hi();
    }
}

// 1. 如果一个类 implements 一个方法，需要重写他设计的方法
class A implements AInterface {
    @Override
    public void hi() {
        System.out.println("hi...");
    }
}