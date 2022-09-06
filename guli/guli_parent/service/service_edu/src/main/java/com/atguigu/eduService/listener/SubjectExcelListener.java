package com.atguigu.eduService.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduService.entity.EduSubject;
import com.atguigu.eduService.entity.Excel.SubjectData;
import com.atguigu.eduService.service.EduSubjectService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    // 因为 SubjectExcelListener 不能交给 spring 进行管理，需要自己 new ，不能注入其他对象
    // 不能实现数据库操作

    public EduSubjectService eduSubjectService;

    // 有参构造
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    // 无参构造
    public SubjectExcelListener() {
    }

    // 一行一行读
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        // 判空
        if (subjectData == null)
            throw new GuliException(20001, "文件数据为空");

        // 一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        // 添加一级分类
        // 判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(subjectData.getOneSubjectName(), eduSubjectService);
        if (existOneSubject == null) {
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName()); // 一级分类名称
            existOneSubject.setSort(subjectData.getThreeSubjectSort()); // 排序字段
            eduSubjectService.save(existOneSubject); // 添加到数据库
        }

        // 获取一级分类中的 id 作为 pid
        String pid = existOneSubject.getId();

        // 添加二级分类
        // 判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(subjectData.getTwoSubjectName(), pid, eduSubjectService);
        if (existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName()); // 二级分类名称
            existOneSubject.setSort(subjectData.getThreeSubjectSort()); // 排序字段
            eduSubjectService.save(existTwoSubject); // 添加到数据库
        }
    }

    // 判断一级分类不能重复添加
    private EduSubject existOneSubject(String name, EduSubjectService eduSubjectService) {
        // 检验是否数据库中已存在科目
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        return eduSubjectService.getOne(wrapper);
    }

    // 判断二级分类不能重复添加
    private EduSubject existTwoSubject(String name, String pid, EduSubjectService eduSubjectService) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        return eduSubjectService.getOne(wrapper);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
