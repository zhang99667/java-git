package chapter06;

public class ArrayAssign {
    public static void main(String[] args) {
        // 数组在默认情况下是引用传递，赋的值是地址，赋值方式为引用赋值
        // 是一个地址，arr2 变化会影响到 arr1
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = arr1;// 把arr1赋给arr2
        arr2[0] = 10; // 修改 arr2

        // 看看arr1的值
        System.out.println("===arrl的元素====");
        for (int i = 0; i < arr1.length; i++)
            System.out.println(arr1[i]);
    }
}
