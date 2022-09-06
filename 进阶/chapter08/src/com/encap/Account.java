package com.encap;

/*
    创建程序，在其中定义两个类：Account和AccountTest类体会Java的封装性。
    Acc0Unt类要求具有属性：姓名（长度为2位3位或4位）、余额（必须20）、
    密码（必须是六位），加果不满足，则刚给出提示信息，并给默认值（程序员自己定）
    通过setXxx的方法给Account的属性赋值。在AccountTest中测试
*/
public class Account {
    // 为了封装将三个属性设置为,private
    private String name;
    private double balance;
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4)
            this.name = name;
        else {
            System.out.println("名字要求长度为 2-4 个字符");
            this.name = "none";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6)
            this.pwd = pwd;
        else {
            System.out.println("密码需为 6 位，默认密码 000000");
            this.pwd = "000000";
        }
    }

    public void showInfo() {
        // 可以增加查看权限
        System.out.println("账号信息:");
        System.out.println("==================================");
        System.out.println("name\tbalance\t\tpwd");
        System.out.println(name + "\t" + balance + "\t" + pwd);
    }
}


