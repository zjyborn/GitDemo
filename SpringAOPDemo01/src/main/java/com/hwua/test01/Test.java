package com.hwua.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hwua.bean.Orgin;
import com.hwua.bean.Target;

public class Test {
	@org.junit.Test
	public void testBefore() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hwua/test01/services.xml");
		Orgin target = (Orgin) ac.getBean("orgin");
		target.show();// 复制当前行代码 ctrl+alt+方向键下
		System.out.println(); // 移动代码 alt+方向键上/下
		target.show1();
		System.out.println();
		target.show2();
		System.out.println();
		target.show3();
		System.out.println();
		Target target2 = ac.getBean("target", Target.class);
		target2.save("测试");
		System.out.println();
		target2.test();
	}
}
