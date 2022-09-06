// 要求：
// (1)在上面类的基础上扩展新类 CheckingAccount 对每次存款和取款都收取 1 美元的手续费
// (2)扩展前一个练习的 BankAccount 类，
// (3)新类 SavingsAccount:每个月都有利息产生 (earnMonthlyInterest方法被调用)，并且有每月三次免手续费的存款或取款。
//    在earnMonthlyInterest方法中重置交易计数
// (4)体会重写的好处

package com.Homework.Homework08;

public class Homework08 {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(1000);
        checkingAccount.deposit(100); // 存100
        checkingAccount.withdraw(50); // 取50

        SavingsAccount savingsAccount = new SavingsAccount(1000);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance()); // 1300 ，有三次免手续费

        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance()); // 1399 ，1块钱手续费

        // 月初了，自动重置并计算利息
        savingsAccount.earnMonthlyInterest(); // 1399+13.99
        System.out.println(savingsAccount.getBalance());

        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance()); // 1712.99 ，有三次免手续费

        savingsAccount.withdraw(100);
        System.out.println(savingsAccount.getBalance()); // 1611.99


    }
}


