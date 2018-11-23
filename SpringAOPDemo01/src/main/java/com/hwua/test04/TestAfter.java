package com.hwua.test04;

import org.aspectj.lang.JoinPoint;

public class TestAfter {
	public void doAfter(JoinPoint jp) {
		System.out.println("******最终通知无论目标组件是否正常执行，都会执行");
	}
}
