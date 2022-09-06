package chapter07.Homework;

public class Homework01 {
    public static void main(String[] args) {
        A01 a01 = new A01();
        double[] arr = { 1.0, 1.3, 3.5, 1.4, -0.3, 11.1 };
        Double res = a01.getMax(arr);

        if (res != null)
            System.out.println("max = " + res);
        else
            System.out.println("输入有误！");
    }
}

// 编写类 A01，定义方法 ma×，实现求某个 double 数组的最大值，并返回
// 先完成正常业务，在考虑代码健壮性
class A01 {
    public Double getMax(double[] arr) {
        // 若arr = null 则会出现空指针异常，故先判断是否为空
        if (arr != null && arr.length > 0) {
            double max = arr[0]; // 假定第一个元素就是最大值
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max)
                    max = arr[i];
            }
            return max; // 返回类型double
        } else
            return null;
    }
}