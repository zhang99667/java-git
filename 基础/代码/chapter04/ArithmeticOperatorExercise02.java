package chapter04;
public class ArithmeticOperatorExercise02 {
    public static void main(String[] args) {
        // 1.需求：
        // 假如还有59天放假，问：合 xx 个星期零 xx 天
        int days = 59;
        int leftDays = days % 7;
        int weeks = 59 / 7;
        System.out.println(days + "天有" + weeks + "个星期" + "零" + leftDays + "天");

        // 1.需求：
        // 定义一个变量保存华氏温度，华氏温度转换摄氏温度的公式为：5 / 9 *（华氏温度-100)，请求出华氏温度对应的摄氏温度。[234.5]
        double huashi = 234.5;
        double sheshi = 5.0 / 9 * (huashi - 100); // 考虑数学公式和 Java计算的区别
        System.out.println("华氏：" + huashi + "对应摄氏为" + sheshi);
    }
}
