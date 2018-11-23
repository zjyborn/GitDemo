package com.hwua.dao.impl;

import java.util.List;

import com.hwua.dao.ITeacherDao;
import com.hwua.entity.Teacher;
import com.hwua.utils.MyBatisUtils;

public class ITeacherDaoImpl implements ITeacherDao {

	public List<Teacher> findAllTeachers() {
		ITeacherDao tdao = (ITeacherDao) MyBatisUtils.getMapper(ITeacherDao.class);
		List<Teacher> tlist = tdao.findAllTeachers();
		MyBatisUtils.closeSqlSession();
		return tlist;
	}


}
