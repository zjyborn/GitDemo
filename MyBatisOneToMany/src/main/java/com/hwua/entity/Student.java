package com.hwua.entity;

/**
 * 实体类 学生--班级1对象
 * 
 * @author oracleOAEC
 *
 */
public class Student {
	private int s_id;
	private String s_name;
	private Classes classes; // association

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Student(int s_id, String s_name, Classes classes) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.classes = classes;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", classes=" + classes + "]";
	}

}
