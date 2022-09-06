package com.Homework.Homework08;

public class SavingsAccount extends BankAccount {
    private int count = 3; // 重置次数
    private double rate = 0.01; // 利率

    // 无参构造器
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public void deposit(double amount) {
        // 判断是否还可以免手续费
        if (count > 0)
            super.deposit(amount);
        else
            super.deposit((amount - 1));
        count--;
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0)
            super.withdraw(amount);
        else
            super.withdraw(amount + 1);
        count--;
    }

    // 计算利息
    // 每个月，统计上个月的利息，同时将 count = 3
    public void earnMonthlyInterest() {
        this.count = 3; // 重置次数
        super.deposit(this.getBalance() * this.getRate());
    }
}
