package com.itheima.mapper;

import com.itheima.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Insert("INSERT INTO tbl_account (name, money) VALUES (#{name}, #{money})")
    void save(Account account);

    @Delete("DELETE FROM tbl_account WHERE id = #{id}")
    void delete(Integer id);

    void update(Account account);

    @Select("SELECT * FROM tbl_account")
    List<Account> selectAll();

    @Select("SELECT * FROM tbl_account WHERE id = #{id}")
    Account selectById(Integer id);

}
