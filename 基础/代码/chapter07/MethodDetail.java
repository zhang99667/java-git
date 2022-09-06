package chapter07;

public class MethodDetail {
    public static void main(String[] args) {
        AA a = new AA();
        int[] res = a.getSumAndSub(1, 4);
        System.out.println("和=" + res[0]);
        System.out.println("差=" + res[1]);
    }
}

class AA {

    // 2.返回类型可以为任意类型，包含基本类型或引用类型（数组，对象）
    // 看 getsumAndSub
    public int[] getSumAndSub(int n1, int n2) {
        int[] resArr = new int[2];
        resArr[0] = n1 + n2;
        resArr[1] = n1 - n2;
        return resArr;
    }

    // 3.如果方法要求有返回数据类型，则方法体中最后的执行语句必须为 return 值；
    // 而且要求返回值类型必须和 return 的值类型一致或兼容
    public double f1() {
        double d1 = 1.1 * 3;
        return d1;
    }
}
