package com.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("jack");
        account.setBalance(600000);
        account.setPwd("666666");
        account.showInfo();
        System.out.println(account.getBalance());
        System.out.println(account.getPwd());

        Account rose = new Account("rose", 50, "000000");
        rose.showInfo();
    }
}
