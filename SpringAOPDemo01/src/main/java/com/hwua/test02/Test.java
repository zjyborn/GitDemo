package com.hwua.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwua.bean.Target;

public class Test {
	@org.junit.Test
	public void testBefore() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("services02.xml");
		Target target = (Target) ac.getBean("target");
		target.save("save方法参数名");
	}
}
