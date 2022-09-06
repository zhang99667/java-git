package Interface_.InterfaceDetail;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        // new IA(); // 接口不能被实例化
    }
}


// 1. 接口不能被实例化
// 2. 接口中所有的方法都是 public 方法，接口中抽象方法，可以不用 abstract 修饰
// 3. 一个普通类实现接口，必须将该接口的所有方法都实现
// 4. 抽象类实现接口，可以不实现接口方法
interface IA{
    // 没有方法体，需要用 abstract 修饰
    // public abstract void say();

    void say(); // public 和 abstract 都是可以省略的
    void hi();
}

class Cat implements IA{

    @Override
    public void say() {

    }

    @Override
    public void hi() {
        System.out.println("hi..");
    }
}