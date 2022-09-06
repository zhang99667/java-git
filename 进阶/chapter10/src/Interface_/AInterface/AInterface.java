package Interface_.AInterface;

public interface AInterface {
    // 写属性
    public int n1 = 10;

    // 写方法
    // 在接口中，抽象方法，可以省略 Abstract 关键字
    public void hi();

    // 在 jdk8 之后，可以有默认实现方法
    // 但是需要使用 default 关键字去修饰
    default public void ok() {
        System.out.println("ok...");
    }

    // 在 jdk8 以后，可以有静态方法
    public static void cry() {
        System.out.println("cry...");
    }
}