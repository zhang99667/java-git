package com.atguigu.Excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;


public class writeExcel {
    public static void main(String[] args) {
        // 实现 Excel 写操作
        // 1 设置写入的文件夹地址和 Excel 文件的名称
        String fileName = "E:\\Java\\test.xlsx";
        // 2 调用 easyExcel 里面的方法实现写操作
        // write 方法有两个参数，第一个参数时文件路径名称，第二个参数是实体类class
        EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());
    }

    // 创建方法返回 list 集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSname("lucy" + i);
            data.setSno(i);
            list.add(data);
        }
        return list;
    }
}
