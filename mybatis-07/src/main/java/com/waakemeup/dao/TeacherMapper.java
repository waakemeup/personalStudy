package com.waakemeup.dao;

import com.waakemeup.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    //获取老师
    //List<Teacher> getTeacher();

    //获取指定老师下得所有学生及其老师信息
    Teacher getTeacher(@Param("tid") int id);

    //子查询方式
    Teacher getTeacher2(@Param("tid") int id);
}
