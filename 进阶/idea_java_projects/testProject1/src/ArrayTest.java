import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        MyTools tools = new MyTools();
        // .var 快捷键自动分配 变量名
        Scanner myScanner = new Scanner(System.in);
        int[] arr = {10, -1, 8, 0, 34};
        System.out.print("排序前：");
        tools.printArr(arr);
        tools.bubble(arr);
        System.out.print("排序后结果：");
        tools.printArr(arr);
        myScanner.close();

        Person jack = new Person("jack", 20);
        System.out.println(jack.name + jack.age);
    }

}

//创建一个类 MyTools，编写一个方法，可以完成对int数组冒泡排序、
class MyTools {
    public void bubble(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
                if (!flag) break;
            }
            flag = false;
        }
    }

    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}

class Person {
    String name;
    int age;

    // alt + insert 快速构造函数
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}