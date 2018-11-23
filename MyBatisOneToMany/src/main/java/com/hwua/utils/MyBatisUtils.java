package com.hwua.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MyBatisUtils工具类
 * @author oracleOAEC
 *
 */
public class MyBatisUtils {
	public static SqlSessionFactory sqlSessionFactory; //会话工厂
	// ThreadLocal
	public static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	//静态代码块{} 仅仅执行一次  读取配置文件获取sqlSessionFactory
	static {
		InputStream stream = null;
		try {
			// 读取mybatis-config配置文件
			stream = Resources.getResourceAsStream("mybatis-config.xml");
			// 创建SqlSessionFactory对象
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件失败");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取SqlSession对象
	 * @return SqlSession对象
	 */
	public static SqlSession openSqlSession() {
		SqlSession sqlSession = tl.get();
		if (sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
			tl.set(sqlSession);
		}
		return sqlSession;
	}

	/**
	 * 关闭SqlSession对象
	 */
	public static void closeSqlSession() {
		// 获取SqlSession
		SqlSession sqlSession = openSqlSession();
		sqlSession.close();
		tl.remove();
	}

	/**
	 * 事务提交
	 */
	public static void commit() {
		SqlSession sqlSession = openSqlSession();
		sqlSession.commit();
		closeSqlSession();
	}

	/**
	 * 事务回滚
	 */
	public static void rollback() {
		SqlSession sqlSession = openSqlSession();
		sqlSession.rollback();
		closeSqlSession();
	}

	//获取DAO实现
	public static Object getMapper(Class clazz) {
		SqlSession sqlSession = openSqlSession();
		return sqlSession.getMapper(clazz);
	}

}
