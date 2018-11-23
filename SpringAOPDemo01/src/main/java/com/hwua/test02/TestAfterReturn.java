package com.hwua.test02;

import org.aspectj.lang.JoinPoint;

public class TestAfterReturn {
	public void testAfterReturn(JoinPoint jp, Object oRet) {
		System.out.println("目标函数的返回值---" + oRet);
		System.out.println("******后置通知在目标函数正常执行并返回参数后执行");
	}

}
