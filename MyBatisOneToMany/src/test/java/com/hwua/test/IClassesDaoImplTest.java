package com.hwua.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.hwua.dao.IClassesDao;
import com.hwua.dao.impl.IClassesDaoImpl;
import com.hwua.entity.Classes;
import com.hwua.entity.Student;
import com.hwua.entity.Teacher;

public class IClassesDaoImplTest {

	@Test
	public void testFindClassesAndTeacher() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindClassesById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		IClassesDao cdao = new IClassesDaoImpl();
		List<Classes> clist = cdao.findAll();
		for (Classes c : clist) {
			System.out.println("=======班级信息=========");
			System.out.println(c.getCid() + "\t" + c.getCname());
			System.out.println("\t\t====教师信息=========");
			Teacher teacher = c.getTeacher();
			System.out.println("\t\t"+teacher.getTid() + "\t" + teacher.getTname());
			System.out.println("\t\t\t======学员信息============");
			List<Student> slist = c.getStudents();
			for (Student stu : slist) {
				System.out.println("\t\t\t"+stu.getS_id());
				System.out.println("\t\t\t"+stu.getS_name());
			}
			System.out.println("**********************************");
		}

	}

}
