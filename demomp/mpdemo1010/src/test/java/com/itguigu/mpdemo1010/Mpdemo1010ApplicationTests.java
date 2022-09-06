package com.itguigu.mpdemo1010;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itguigu.mpdemo1010.entity.acl_user;
import com.itguigu.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    // 查询 User 表所有数据
    @Test
    public void findAll() {
        List<acl_user> users = userMapper.selectList(null);
        System.out.println(users);
    }

    // 添加操作
    @Test
    public void addUser() {
        acl_user user = new acl_user();
        // user.setId("0000001"); // 主键不写，会自动生成主键
        user.setPassword("0000");
        user.setNick_name("Tom23000");
        user.setUsername("Tom2");

        /*
        // 手动设置时间配置
        user.setGmt_create(new Date());
        user.setGmt_modified(new Date());
        */

        // 或者在实体中使用 @TableField(fill = FieldFill.INSERT) 标签进行自动填充

        int insert = userMapper.insert(user);
        System.out.println("insert:" + insert);
    }


    // 修改操作
    @Test
    public void updateUser() {
        acl_user user = new acl_user();
        user.setId("1296657852869406722");
        user.setUsername("Trump");

        int row = userMapper.updateById(user); // 根据 ID 修改 Username
        System.out.println(row);
    }

    // 测试乐观锁
    @Test
    public void testOptimisticLocker() {
        // 根据 id 查询数据
        acl_user user = userMapper.selectById("1543077955921457154");

        // 进行修改
        user.setPassword(user.getUsername());
        userMapper.updateById(user);
    }


    // 多个 id 的批量查询
    @Test
    public void testSelectDemo1() {
        List<acl_user> users = userMapper.selectBatchIds(Arrays.asList("1296658810076688386", "1296657852869406722"));
        System.out.println(users);
    }

    // 条件查询
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "Trump");
        // map.put("age",18);
        List<acl_user> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

    // 分页查询
    @Test
    public void testPage() {
        // 1 创建 page 对象
        // 传入两个参数：当前页 和 每页显示的记录数
        Page<acl_user> page = new Page<>(1, 3);

        // 调用 mp 的分页查询方法
        // 调用 mp 分页查询过程中，底层封装
        // 把分页数据封装到 page 对象里
        userMapper.selectPage(page, null);

        // 通过 page 对象获取分页数据
        System.out.println("当前页: " + page.getCurrent()); // 当前页
        System.out.println("每页 list 集合: " + page.getRecords()); // 每页 list 集合
        System.out.println("每页显示的记录数: " + page.getSize()); // 每页显示的记录数
        System.out.println("总记录数： " + page.getTotal()); // 总记录数
        System.out.println("总页数： " + page.getPages()); // 总页数

        System.out.println("是否有下一页： " + page.hasNext()); // 是否有下一页
        System.out.println("是否有上一页： " + page.hasPrevious()); // 是否有上一页
    }

    // 删除操作 - 物理删除（如果没添加配置文件）
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById("1543077955921457154");
        System.out.println("result :" + result);
    }

    // 批量删除  - 物理删除
    @Test
    public void testDelete() {
        int result = userMapper.deleteBatchIds(Arrays.asList("1543098594426294273", "1543098653398188033"));
        System.out.println(result);
    }

    // mp 实现复杂查询操作
    @Test
    public void testSelectQuery() {
        // 创建 QueryWrapper 对象
        QueryWrapper<acl_user> wrapper = new QueryWrapper<>();

        // 通过 QueryWrapper 设置条件
        // ge、gt、le、lt 大于、大于等于、小于、小于等于

        // 查询 age >= 30 的记录
        /* wrapper.ge("age", 30);
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println("age >= 30 的记录：\n" + users); */


        // eq、ne 等于、不等于
        /* wrapper.eq("username", "Trump");
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println("name = Trump：\n" + users1); */

       /*  wrapper.ne("username","Trump");
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println(users); */

        // between
        /* wrapper.between("age",20,30);
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println(users); */


        // like 模糊查询
        /* wrapper.like("username","T");
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println(users); */

        // orderByDesc 降序排序
        /* wrapper.orderByAsc("age");
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println(users); */

        // last 直接拼接到 sql 最后
        /* wrapper.last("limit 1"); // 向后面拼一条 sql 语句
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println(users); */

        // 指定要查询的列
        wrapper.select("id","username","password");
        List<acl_user> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }


}


