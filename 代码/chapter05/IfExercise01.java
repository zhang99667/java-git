package chapter05;

// 单分支和双分支练习
public class IfExercise01 {
    public static void main(String[] args) {
        // 编写程序，声明 2 个 double 型变量并赋值

        double d1 = 34.5;
        double d2 = 2.6;
        if (d1 > 10.0 && d2 < 2.0)
            System.out.println("两数之和" + d1 + d2);

        // 【课后自练】定义两个变量 int，判断二者的和
        // 是否能被 3 又能被 5 整除，打印提示信息
        int num1 = 10;
        int num2 = 5;
        int sum = num1 + num2;
        if (sum % 3 == 0 && sum % 5 == 0)
            System.out.println("和可以被 3 和 5 整除！");
        else
            System.out.println("和不能被 3 和 5 整除！");

        // 判断一个年份是否是闰年，闰年的条件是符合下面王者之一；
        // (1)年份能被 4 整除，但不能被 100 整除；(2)能被 400 整除

        int year = 2022;
        if (year % 4 == 0 && year % 100 != 0) {
            if (year % 400 == 0)
                System.out.println(year + "年是闰年！");
            else
                System.out.println(year + "年不是闰年！");
        } else
            System.out.println(year + "年不是闰年！");
    }
}
