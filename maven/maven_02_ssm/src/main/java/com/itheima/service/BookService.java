package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 添加
     *
     * @param book
     * @return
     */
    public boolean save(Book book);

    /**
     * 更新
     *
     * @param book
     * @return
     */
    public boolean update(Book book);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     * 根据 id 查询
     *
     * @param id
     * @return
     */
    public Book selectById(int id);

    /**
     * 查询全部
     *
     * @return
     */
    public List<Book> selectAll();
}
