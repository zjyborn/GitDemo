package bin;

import java.io.Serializable;

public class Easybuy_user implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private  String eu_user_id;//用户名
 private String eu_user_name;//真实姓名
 private String eu_password;//密码
 private int eu_sex;//性别0男，1女
 private String eu_birthday;//出生
 private String eu_identity_code;//身份证
 private String eu_email;
 private String eu_mobile;
 private String eu_address;
 private int eu_login;//是否登录
 private int eu_status;//1普通用户登录2管理员
 
public Easybuy_user() {
	super();
}

public Easybuy_user(String eu_user_id, String eu_user_name, String eu_password, int eu_sex, String eu_birthday,
		String eu_mobile, String eu_address) {
	super();
	this.eu_user_id = eu_user_id;
	this.eu_user_name = eu_user_name;
	this.eu_password = eu_password;
	this.eu_sex = eu_sex;
	this.eu_birthday = eu_birthday;
	this.eu_mobile = eu_mobile;
	this.eu_address = eu_address;
}

public Easybuy_user(String eu_user_id, String eu_user_name, String eu_password, int eu_sex, String eu_birthday,
		String eu_identity_code, String eu_email, String eu_mobile, String eu_address, int eu_login, int eu_status) {
	super();
	this.eu_user_id = eu_user_id;
	this.eu_user_name = eu_user_name;
	this.eu_password = eu_password;
	this.eu_sex = eu_sex;
	this.eu_birthday = eu_birthday;
	this.eu_identity_code = eu_identity_code;
	this.eu_email = eu_email;
	this.eu_mobile = eu_mobile;
	this.eu_address = eu_address;
	this.eu_login = eu_login;
	this.eu_status = eu_status;
}

public String getEu_user_id() {
	return eu_user_id;
}

public void setEu_user_id(String eu_user_id) {
	this.eu_user_id = eu_user_id;
}

public String getEu_user_name() {
	return eu_user_name;
}

public void setEu_user_name(String eu_user_name) {
	this.eu_user_name = eu_user_name;
}

public String getEu_password() {
	return eu_password;
}

public void setEu_password(String eu_password) {
	this.eu_password = eu_password;
}

public int getEu_sex() {
	return eu_sex;
}

public void setEu_sex(int eu_sex) {
	this.eu_sex = eu_sex;
}

public String getEu_birthday() {
	return eu_birthday;
}

public void setEu_birthday(String eu_birthday) {
	this.eu_birthday = eu_birthday;
}

public String getEu_identity_code() {
	return eu_identity_code;
}

public void setEu_identity_code(String eu_identity_code) {
	this.eu_identity_code = eu_identity_code;
}

public String getEu_email() {
	return eu_email;
}

public void setEu_email(String eu_email) {
	this.eu_email = eu_email;
}

public String getEu_mobile() {
	return eu_mobile;
}

public void setEu_mobile(String eu_mobile) {
	this.eu_mobile = eu_mobile;
}

public String getEu_address() {
	return eu_address;
}

public void setEu_address(String eu_address) {
	this.eu_address = eu_address;
}

public int getEu_login() {
	return eu_login;
}

public void setEu_login(int eu_login) {
	this.eu_login = eu_login;
}

public int getEu_status() {
	return eu_status;
}

public void setEu_status(int eu_status) {
	this.eu_status = eu_status;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
public String toString() {
	return "Easybuy_user [eu_user_id=" + eu_user_id + ", eu_user_name=" + eu_user_name + ", eu_password=" + eu_password
			+ ", eu_sex=" + eu_sex + ", eu_birthday=" + eu_birthday + ", eu_identity_code=" + eu_identity_code
			+ ", eu_email=" + eu_email + ", eu_mobile=" + eu_mobile + ", eu_address=" + eu_address + ", eu_login="
			+ eu_login + ", eu_status=" + eu_status + "]";
}









 
 
}
