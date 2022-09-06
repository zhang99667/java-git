package com.Homework.Homework08;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    // 重写存款方法
    public void deposit(double amount) {
        super.deposit(amount - 1); // 1块钱手续费，存10块钱相当于存9块钱
        // 1块钱入银行账户
    }

    @Override
    // 重写取款方法
    public void withdraw(double amount) {
        super.withdraw(amount + 1); // 1 块钱手续费 ，取10块钱相当于取11
        // 1块钱入银行账户
    }
}
