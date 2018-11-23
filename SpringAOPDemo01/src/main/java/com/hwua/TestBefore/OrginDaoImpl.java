package com.hwua.TestBefore;

import java.util.List;

/**
 * 
 * @ClassName: OrginDaoImpl
 * @Description:TODO(被代理对象 原程序 商家)
 * @author: maple
 * @date: 2018年11月14日 下午4:30:36
 * 
 * @Copyright: 2018 www.hwua.com Inc. All rights reserved.
 *             注意：本内容仅限于海文科信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class OrginDaoImpl {

	public List<Integer> getAllUsers() {
		System.out.println("Dao层执行------ 查询所有用户功能---------");
		return null;
	}

	public boolean saveUsers(Integer i) {
		System.out.println("Dao层执行------ 添加用户功能---------");
		return false;

	}

}
