package chapter05;

import java.util.Scanner;

public class BreakExercise02 {
    public static void main(String[] args) {
        // 实现登录验证，有3次机会，如果用户名为"丁真”，密码"666提示登录成功
        // 否则提示还有几次机会，请使用 for + break 完成
        Scanner myScanner = new Scanner(System.in);
        int chance = 3; // 记录还有几次登陆机会
        while (chance > 0) {
            System.out.println("请输入名字：");
            String name = myScanner.next(); // 接受用户名
            System.out.println("请输入密码：");
            String password = myScanner.next(); // 接受密码

            // 字符串之间的比较需要用 equals
            if ("丁真".equals(name)) { // 验证用户名
                if ("666".equals(password)) { // 验证密码
                    System.out.println("登陆成功！");
                    break;
                } else {
                    chance--;
                    System.out.println("密码错误！还有机会" + chance + "次");
                }
            } else {
                chance--;
                System.out.println("用户名错误！还有机会" + chance + "次");
            }
        }
        myScanner.close();
    }
}
