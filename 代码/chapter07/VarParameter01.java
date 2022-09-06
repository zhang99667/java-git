package chapter07;

public class VarParameter01 {
    public static void main(String[] args) {
        HspMethod m = new HspMethod();
        System.out.println(m.sum(1, 5, 100));
        System.out.println(m.sum(1, 19));
    }
}

class HspMethod {
    // 可以计算 2 个数的和，3 个数的和，4,5.。。
    // 可以使用方法重载
    /*
     * public int sum(int n1, int n2) { // 两个数的和
     * return n1 + n2;
     * }
     * 
     * public int sum(int n1, int n2, int n3) { // 三个数的和
     * return n1 + n2 + n3;
     * }
     * 
     * public int sum(int n1, int n2, int n3, int n4) {
     * return n1 + n2 + n3 + n4;
     * }
     */

    // 上面的三个方法名称相同，功能相同，参数个数不同 -> 使用可变参数优化
    // 老韩解读
    // 1. int...表示接受的是可变参数，类型是 int , 即可以接收多个 int
    // 2. 使用可变参数时，可以当做数组来使用 即 nums 可以当数组
    // 3. 遍历 nums 求和即可
    public int sum(int... nums) {
        System.out.println("接受得参数个数 = " + nums.length);
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res += nums[i];
        return res;
    }
}

