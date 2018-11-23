package com.hwua.test03;

import org.aspectj.lang.JoinPoint;

public class TestThrowing {
	public void doThrow(JoinPoint jp, Throwable e) {
		System.err.println(e.getMessage());
		System.err.println("******异常通知在目标组件抛出异常后执行");
	}
}
