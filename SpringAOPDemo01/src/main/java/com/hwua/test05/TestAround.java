package com.hwua.test05;

import org.aspectj.lang.ProceedingJoinPoint;

public class TestAround {
	public void doAround(ProceedingJoinPoint pjp) {
		System.out.println("前置通知");
		try {
			Object ob = pjp.proceed();
			System.out.println("目标函数的返回值" + ob);
		} catch (Throwable e) {
			System.out.println("异常通知");
		} finally {// 无论是否有异常 最终都将执行
			System.out.println("最终通知");
		}
		// 无异常的情形下会执行 后置通知
		System.out.println("后置通知");
	}
}