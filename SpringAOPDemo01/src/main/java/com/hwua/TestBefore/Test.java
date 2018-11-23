package com.hwua.TestBefore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		OrginDaoImpl odao=new OrginDaoImpl();
		//dao层调用查询所有的方法
		odao.getAllUsers();
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		OrginDaoImpl daoImpl=ctx.getBean("orginDaoImpl",OrginDaoImpl.class);
		daoImpl.saveUsers(1);
	}

}
