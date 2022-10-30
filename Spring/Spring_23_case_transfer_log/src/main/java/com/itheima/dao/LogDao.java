package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface LogDao {

    @Insert("INSERT INTO tbl_log (tbl_log.info,tbl_log.createDate) VALUES(#{info}, #{createDate})")
    void addLog(@Param("info") String info, @Param("createDate") String createDate);
}
