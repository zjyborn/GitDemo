package com.hwua.dao.impl;

import java.util.List;

import com.hwua.dao.IClassesDao;
import com.hwua.entity.Classes;
import com.hwua.utils.MyBatisUtils;

public class IClassesDaoImpl implements IClassesDao {

	public List<Classes> findClassesAndTeacher() {
		IClassesDao cdao = (IClassesDao) MyBatisUtils.getMapper(IClassesDao.class);
		List<Classes> clist = cdao.findClassesAndTeacher();
		MyBatisUtils.closeSqlSession();
		return clist;
	}

	public List<Classes> findClassesById(int cid) {
		IClassesDao cdao = (IClassesDao) MyBatisUtils.getMapper(IClassesDao.class);
		List<Classes> clist = cdao.findClassesById(cid);
		MyBatisUtils.closeSqlSession();
		return clist;
	}

	public List<Classes> findAll() {
		IClassesDao cdao = (IClassesDao) MyBatisUtils.getMapper(IClassesDao.class);
		List<Classes> clist = cdao.findAll();
		MyBatisUtils.closeSqlSession();
		return clist;
	}

}
