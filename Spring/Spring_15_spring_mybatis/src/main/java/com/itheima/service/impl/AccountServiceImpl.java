package com.itheima.service.impl;

import com.itheima.pojo.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) {
        accountMapper.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountMapper.delete(id);
    }

    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }

    @Override
    public List<Account> selectAll() {
        List<Account> accounts = accountMapper.selectAll();
        return accounts;
    }

    @Override
    public Account selectById(Integer id) {
        Account account = accountMapper.selectById(id);
        return account;
    }
}
