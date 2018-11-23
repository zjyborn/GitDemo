package com.hwua.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwua.bean.Target;

public class Test {
	@org.junit.Test
	public void testBefore() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("services04.xml");
		Target target = (Target) ac.getBean("target");
		target.save("save方法参数名");
	}
}
