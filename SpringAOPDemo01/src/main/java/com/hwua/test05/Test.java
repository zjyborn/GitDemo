package com.hwua.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwua.bean.Orgin;
import com.hwua.bean.Target;

public class Test {
	@org.junit.Test
	public void testBefore() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("services05.xml");
		Target target = (Target) ac.getBean("target");
		target.save("save方法参数名");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
//		Orgin target2 = (Orgin) ac.getBean("orgin");
//		target2.show();
		target.test();
	}
}
