package com.Homework.Homework08;

public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.setBalance(initialBalance);
    }

    // 存款
    public void deposit(double amount) {
        balance += amount;
    }

    // 取款
    public void withdraw(double amount) {
        balance -= amount;
    }

    // set和getBalance方法
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
