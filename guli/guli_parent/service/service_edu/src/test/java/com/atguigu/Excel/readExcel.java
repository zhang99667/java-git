package com.atguigu.Excel;

import com.alibaba.excel.EasyExcel;

public class readExcel {
    public static void main(String[] args) {
        // 文件路径和名称
        String fileName = "E:\\Java\\test.xlsx";

        // 读操作
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();
    }
}