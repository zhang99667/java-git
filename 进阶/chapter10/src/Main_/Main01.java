package Main_;

public class Main01 {
    // 静态变量
    private static String name = "小明";
    // 非静态变量
    private int n1 = 10;

    // 静态方法
    public static void hi() {
        System.out.println("Main01的hi方法");
    }

    public void cry(){
        System.out.println("Main01的cry方法");
    }

    public static void main(String[] args) {

        // 1. 静态方法可以访问本类的静态成员
        System.out.println("name=" + name);

        // 2. 静态方法main，不可以访问本类的非静态成员
        // System.out.println("n1="+n1);

        hi();

        // 3. 静态方法main，不能访问本类的非静态方法
        // cry();

        //3。静态方法main要访问本类的非静态成员，需要先创建对象，再调用即可
        Main01 main = new Main01();
        main.cry();
        System.out.println(main.n1);
    }
}
