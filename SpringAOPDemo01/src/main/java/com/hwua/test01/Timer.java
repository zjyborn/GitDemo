package com.hwua.test01;

import java.util.Date;

//快递公司 ---代理对象  ---对其功能进行增强
public class Timer {
	public void showTime() {
		//记录当前进入方法 的时间点为
		System.out.println(new Date());
	}
}
