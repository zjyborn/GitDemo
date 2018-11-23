package com.hwua.dao;
/**
 * 班级信息
 * @author oracleOAEC
 *
 */

import java.util.List;

import com.hwua.entity.Classes;

public interface IClassesDao {
	/**
	 * 查询所有信息
	 * @return
	 */
	public List<Classes> findClassesAndTeacher();
	/**
	 * 
	 * @param cid
	 * @return 班级信息包含教师信息
	 */
	public List<Classes> findClassesById(int cid);
	
	public List<Classes> findAll();
}
