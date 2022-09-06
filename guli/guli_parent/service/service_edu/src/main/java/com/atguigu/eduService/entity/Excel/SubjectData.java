
package com.atguigu.eduService.entity.Excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@ColumnWidth(30)//注释在具体属性上,设置单独列。注释在类上,统一设置列宽
@HeadRowHeight(30)//设置表头行高
@ContentRowHeight(20)//统一设置数据行行高
public class SubjectData {
    @ExcelProperty(value = "一级标题", index = 0)
    private String oneSubjectName;

    @ExcelProperty(value = "二级标题", index = 1)
    private String twoSubjectName;

    @ExcelProperty(value = "排序字段",index = 2)
    private Integer threeSubjectSort;
}
