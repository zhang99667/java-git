package com.atguigu.eduService.controller;

import com.atguigu.commonUtils.R;
import com.atguigu.eduService.entity.EduTeacher;
import com.atguigu.eduService.entity.vo.TeacherQuery;
import com.atguigu.eduService.service.EduTeacherService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-02
 */
@RestController // 接口返回 json 数据
@RequestMapping("/eduService/edu_teacher") // 访问路径
@CrossOrigin
public class EduTeacherController {

    // 访问地址：http://localhost:8080/eduService/edu-teacher/findAll
    // 把service注入
    @Autowired // 自动装配注解
    private EduTeacherService teacherService;

    // 1 查询讲师表中的所有数据
    // rest 风格
    @ApiOperation(value = "显示所有讲师列表")
    @GetMapping("findAll")
    // public List<EduTeacher> findAllTeacher() {
    public R findAllTeacher() {
        // 调用 service 的方法，实现查询所有的操作
        List<EduTeacher> teacherList = teacherService.list(null);

        // return teacherList;
        return R.ok().data("rows", teacherList);
    }


    // 2 逻辑删除讲师的方法
    @ApiOperation(value = "根据 ID 逻辑删除讲师")
    @DeleteMapping("{id}") // 表示 id 值需要通过路径进行传递
    public R removeTeacher(@ApiParam(name = "id", value = "讲师ID") @PathVariable String id) { // 获取到路径中已输入的 id 值
        return teacherService.removeById(id) ? R.ok() : R.error();
    }

    // 3 分页查询讲师的方法
    @ApiOperation("分页查询讲师")
    @GetMapping("pageTeacher/{current}/{limit}")

    private R pageListTeacher(@ApiParam(name = "current", value = "当前页") @PathVariable int current,
                              @ApiParam(name = "limit", value = "每页个数") @PathVariable int limit) {
        // 创建Page对象
        Page<EduTeacher> pageTeacher = new Page<>(current, limit); // 每页记录三个

        // 实现排序
        // 创建 wrapper 对象 - 构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("gmt_create");
        // 调用方法实现分页
        // 调用方法的时候，底层封装，把分页所有数据封装到 pageTeacher
        teacherService.page(pageTeacher, wrapper);

        long total = pageTeacher.getTotal(); // 总记录数
        List<EduTeacher> records = pageTeacher.getRecords(); // 数据list集合

        Map map = new HashMap<>(); // 创建一个 Map 结构存放数据
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
        // return R.ok().data("total",total).data("rows",records); // 第二种写法
    }

    // 4 带分页的多条件组合查询
    @ApiOperation("带分页的多条件组合查询讲师")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable int current, @PathVariable int limit, @RequestBody(required = false) TeacherQuery teacherQuery) {
        // RequestBody 通过 json 传数据、ResponseBody 返回 json 数据

        // 创建 page 对象
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);
        // 创建 wrapper 对象 - 构建条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        // 多条件组合查询，设置 wrapper
        // mybatis 动态 sql
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        // 根据条件值判断
        // 判断条件值是否为空，如果不为空则拼接条件
        if (!ObjectUtils.isEmpty(name)) {
            // 构建条件
            wrapper.like("name", name);
        }
        if (!ObjectUtils.isEmpty(level)) {
            // 构建条件
            wrapper.eq("level", level);
        }
        if (!ObjectUtils.isEmpty(begin)) {
            // 时间大于 begin
            wrapper.ge("gmt_create", begin);
        }
        if (!ObjectUtils.isEmpty(end)) {
            // 时间小于 end
            wrapper.le("gmt_create", end);
        }

        // 排序
        wrapper.orderByDesc("gmt_create");

        // 调用方法实现条件查询
        teacherService.page(pageTeacher, wrapper);

        long total = pageTeacher.getTotal(); // 获取总记录数
        List<EduTeacher> records = pageTeacher.getRecords();
        Map map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    // 5 添加讲师接口的方法
    @ApiOperation("添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
        return teacherService.save(eduTeacher) ? R.ok() : R.error();
    }

    // 6 根据讲师 ID 查询
    @ApiOperation("根据讲师 ID 查询")
    @GetMapping("getTeacher/{id}")
    public R getTeacher(@ApiParam(name = "id", value = "讲师 ID") @PathVariable String id) {
        EduTeacher eduTeacher = teacherService.getById(id);
        if (eduTeacher == null) return R.error().data("message", eduTeacher);
        return R.ok().data("teacher", eduTeacher);
    }

    // 7 修改讲师接口的方法
    @ApiOperation("根据 ID 修改讲师")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        return teacherService.updateById(eduTeacher) ? R.ok().data("rows", eduTeacher) : R.error().data("message", eduTeacher);
    }


    // 8 自定义异常处理
    public void ExceptionTest() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            // 执行自定义异常
            throw new GuliException(20001, "执行了自定义异常，errorCode:20001");
        }
    }

}