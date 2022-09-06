package chapter07;

public class MethodParameter02 {
    public static void main(String[] args) {
        BBB b = new BBB();
        int[] arr = { 1, 2, 3 };

        b.test100(arr);

        System.out.println("main 的 arr数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println();

        Person1 p = new Person1();
        p.name = "jack";
        p.age = 10;
        System.out.println("main 的p.age = " + p.age);
        b.test200(p);
        System.out.print("修改后的main中的p.age：\n" + p.age);
        System.out.println();
    }

}

class Person1 {
    String name;
    int age;
}

class BBB {
    // B类中编写一个方法test100
    // 可以接收一个数组，在方法中修改该数组，看看原来的数组是否变化
    public void test100(int[] arr) {
        arr[0] = 200; // 修改元素
        // 遍历数组
        System.out.println("test 100 的 arr数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println();
    }

    public void test200(Person1 p) {
        // p.age = 1000; // 修改对象属性
        // System.out.println("test200 的 p.age = " + p.age);
        // p = null;

        // 开辟新的 p
        p = new Person1();
        p.name = "tom";
        p.age = 50;

    }
}
