package com.hwua.entity;

/**
 * Teacher表
 * 
 * @author oracleOAEC
 *
 */
public class Teacher {
	private Integer tid; // tid-->t_id
	private String tname; // tname-->t_name

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + "]";
	}

	public Teacher() {
		super();
	}

	public Teacher(Integer tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

}
