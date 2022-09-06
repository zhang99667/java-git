package com.atguigu.eduService.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduService.entity.EduSubject;
import com.atguigu.eduService.entity.Excel.SubjectData;
import com.atguigu.eduService.entity.subject.OneSubject;
import com.atguigu.eduService.entity.subject.TwoSubject;
import com.atguigu.eduService.listener.SubjectExcelListener;
import com.atguigu.eduService.mapper.EduSubjectMapper;
import com.atguigu.eduService.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-07-19
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Autowired
    private EduSubjectService subjectService;

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        // 查询所有一级分类
        wrapperOne.eq("parent_id", "0");
        // List<EduSubject> one = baseMapper.selectList(wrapperOne);
        List<EduSubject> oneEduSubjectList = subjectService.list(wrapperOne);

        // 查询所有二级分类
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id", "0");
        List<EduSubject> twoEduSubjectList = subjectService.list(wrapperTwo);
        // 创建 list 集合，用于存储最终封装的数据
        List<OneSubject> finalSubjectList = new ArrayList<>();

        // 封装一级分类
        // 查询出来的所有的一级分类 list 集合遍历，得到每个一级分类对象，获取每一个一级分类对象值
        // 封装到要求的 list 集合里面 List<OneSubject> finalSubjectList
        for (int i = 0; i < oneEduSubjectList.size(); i++) {
            // 得到 oneSubjectList 中的每一个 eduSubject 对象
            EduSubject oneEduSubject = oneEduSubjectList.get(i);
            // 把 eduSubject 里面值获取出来，放到 OneSubject 对象里面
            OneSubject oneSubject = new OneSubject();

            // 多个 OneSubject 放到 finalSubjectList 里面
            // 手动实现
            // oneSubject.setId(onewEduSubject.getId());
            // oneSubject.setTitle(onewEduSubject.getTitle());
            // oneSubject.setSort(onewEduSubject.getSort());
            // 使用工具类实现上述两行代码的同样功能
            BeanUtils.copyProperties(oneEduSubject, oneSubject);

            // 添加到 list 中
            finalSubjectList.add(oneSubject);

            // 封装二级分类
            // 在一级分类循环遍历查询所以的二级分类
            // 创建 list 集合封装每一个一级分类的二级分类
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            // 遍历二级分类
            for (int j = 0; j < twoEduSubjectList.size(); j++) {
                // 从 twoEduSubjectList 中获取每一个二级分类到 twoEduSubject 中
                EduSubject twoEduSubject = twoEduSubjectList.get(j);
                // 判断二级分类的 parent_id 和一级分类的 id 是否一致
                if (twoEduSubject.getParentId().equals(oneEduSubject.getId())) {
                    // 创建一个 twoSubject 用于存放
                    TwoSubject twoSubject = new TwoSubject();
                    // 复制属性
                    BeanUtils.copyProperties(twoEduSubject, twoSubject);
                    // 添加至列表
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            // 把所有二级分类放到一级分类中
            oneSubject.setChildren(twoFinalSubjectList);
        }
        return finalSubjectList;
    }
}
