package com.hwua.entity;

import java.util.List;

/**
 * 实体类班级 班级1--学生n
 * 
 * @author oracleOAEC
 *
 */
public class Classes {
	private Integer cid;// cid-->c_i
	private String cname;// cname->c_name
	private Teacher teacher; // teacher_id -->Teacher(t_id t_name)
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Classes(Integer cid, String cname, Teacher teacher) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher = teacher;
	}

	public Classes() {
		super();
	}

	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", teacher=" + teacher + "]";
	}

}
