package com.hwua.dao;
/**
 * TeacherDao层接口
 * @author oracleOAEC
 *
 */

import java.util.List;

import com.hwua.entity.Teacher;

public interface ITeacherDao {
	public List<Teacher> findAllTeachers();
	
}
