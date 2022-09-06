package com.smallchange.OOP;

// 完成零钱通的各个功能的类
// 使用OOP（面向对象编程）
// 将各个功能对应一个方法

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    // 定义相关的变量
    boolean loop = true; // 菜单是否循环显示，可以用来退出菜单
    Scanner myScanner = new Scanner(System.in);
    String key;

    // 2. 完成零钱通明细
    // 老韩思路：(1)可以把收益入账和消费，保存到数组 (2)可以使用对象 (3)简单的话可以使用 String 拼接
    String detail = "------------------零钱通明细OOP------------------";

    // 3. 完成收益入账完成功能驱动程序员增加新的变化和代码
    // 老韩思路，定义新的变量
    double money;
    double balance = 0;
    Date date;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    // 4. 消费
    String note;

    // 5.退出
    // 用户输入 4 退出时，给出提示"你确定要退出吗？”，必须输入正确的 y / n,
    // 否则循环输入指令，直到输入 y 或者 n
    String y_n;


    // 显示菜单，并可以选择
    public void mainMenu() {
        do {
            System.out.println("------------------零钱通菜单OOP------------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退\t出");
            System.out.println("请选择（1-4）");

            key = myScanner.next();
            switch (key) {
                // 明细
                case "1":
                    this.detail();
                    break;
                // 收益
                case "2":
                    System.out.print("收益入账金额：");
                    // 输入收益
                    money = myScanner.nextDouble();
                    // 判断收益金额是否正确
                    if (money <= 0)
                        System.out.println("输入收益有误！请重新输入！");
                    else
                        this.income();
                    break;
                // 消费
                case "3":
                    System.out.print("消费金额：");
                    // 输入消费
                    money = myScanner.nextDouble();
                    // 判断消费是否正确
                    if (money <= 0 || money > balance)
                        System.out.println("输入消费金额有误");
                    else
                        this.pay();
                    break;
                // 退出
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("选择错误，请重新输入");
            }
        }
        while (loop);
    }


    // 零钱通明细
    public void detail() {
        System.out.println(detail);
    }

    // 完成收益入账
    public void income() {
        // 计算余额
        balance += money;
        // 拼接收益入账信息到 details
        date = new Date();
        detail += "\n收益入账\t+" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
    }


    public void pay() {
        // 计算余额
        balance -= money;
        System.out.println("消费说明：");
        // 输入消费信息
        note = myScanner.next();

        // 拼接消费信息到 details
        date = new Date();
        detail += "\n" + note + "\t-" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
    }

    public void exit() {
        // 建议一段代码，完成一个小功能，尽量不要混在一起
        // 循环判断输入 y/n
        while (true) {
            System.out.println("你确定要退出吗？y/n");
            // 输入选择信息
            y_n = myScanner.next();
            if (y_n.equals("y") || y_n.equals("n"))
                break;
        }
        // 退出 while 判断输入信息是否为 y
        if (y_n.equals("y")) loop = false;
    }
}
