package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> selectAll();

    Account selectById(Integer id);
}
