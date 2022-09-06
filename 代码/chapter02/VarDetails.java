package chapter02;
public class VarDetails {

    public static void main(String[] args) {
        // 变量必须先声明，后使用，即有顺序
        int a = 50;// int
        System.out.println(a);// 50
        // 该区域的数据/值可以在同一类型范围内不断变化
        // a = "jack";
        a = 88;// 对
        System.out.println(a);// 88
    }
}