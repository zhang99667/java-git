package chapter06.Homework;

public class Homework02 {
    public static void main(String[] args) {
        /*
         * 随机生成10个整数(1_100的范围)保存到数组
         * 并倒序打印以及求平均值、求最大值和最大值的下标
         * 并查找里面是否有 8
         */

        int[] arr = new int[10];

        // 随机生成数组
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100);

        // 输出数组
        System.out.println("当前数组为：");
        for (int i = 0; i < arr.length; i++)
            System.out.printf("%d,", arr[i]);
        System.out.println("");

        // 倒序输出数组
        System.out.println("倒序输出结果为：");
        for (int i = arr.length - 1; i >= 0; i--)
            System.out.printf("%d,", arr[i]);
        System.out.println("");

        // 求和数组
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        System.out.println("平均值：" + (sum / 10));

        int index = 0; // 记录最大最小值所在下标

        // 最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println("最大值：" + max + " 下标为：" + index);

        // 最小值
        index = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println("最小值：" + min + " 下标为：" + index);

        // 找 8
        index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 8) {
                index = i;
                System.out.println("已找到。下标为：" + index);
            }

        }
        if (index == -1)
            System.out.println("未找到数字8！");

    }
}
