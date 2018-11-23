package com.hwua.test01;

import org.aspectj.lang.JoinPoint;

public class TestBefore {
	public void doBefore(JoinPoint jp) {//连接点
		System.out.println("获取目标函数参数方式：" + jp.getArgs()[0]);
		System.out.println("获取目标对象：" + jp.getTarget().getClass().getName());
		System.out.println("获取目标函数的java反射对象：" + jp.getSignature());
		System.out.println("******执行前置通知");
	}
}
