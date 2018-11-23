package com.hwua.TestBefore;

import java.util.Date;

//快递公司 ---代理对象  ---对其功能进行增强
/**
 * 
 * @ClassName:  Timer  切面
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: maple
 * @date:   2018年11月14日 下午4:36:26   
 *     
 * @Copyright: 2018 www.hwua.com Inc. All rights reserved. 
 * 注意：本内容仅限于海文科信息技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class Timer {
	public void showTime() {
		//记录当前进入方法 的时间点为
		System.out.println(new Date());
	}
}
