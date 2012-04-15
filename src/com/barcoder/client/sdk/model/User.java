package com.barcoder.client.sdk.model;

import java.util.Date;

public class User {

	private String account_email;
	private Boolean sex;
	private String name;
	private Date birthday;
	private String university_name;
	private Integer university_year;
	private String university_department;
	private String phone;
	private String head_urlString;
	private String personal_page;
	private String password;
	private Date last_login;
	private Date joined_time;
	private Boolean is_host;
	private Boolean exist_flag;

	public String getAccount_email() {
		return account_email;
	}

	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public Integer getUniversity_year() {
		return university_year;
	}

	public void setUniversity_year(Integer university_year) {
		this.university_year = university_year;
	}

	public String getUniversity_department() {
		return university_department;
	}

	public void setUniversity_department(String university_department) {
		this.university_department = university_department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHead_urlString() {
		return head_urlString;
	}

	public void setHead_urlString(String head_urlString) {
		this.head_urlString = head_urlString;
	}

	public String getPersonal_page() {
		return personal_page;
	}

	public void setPersonal_page(String personal_page) {
		this.personal_page = personal_page;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public Date getJoined_time() {
		return joined_time;
	}

	public void setJoined_time(Date joined_time) {
		this.joined_time = joined_time;
	}

	public Boolean getIs_host() {
		return is_host;
	}

	public void setIs_host(Boolean is_host) {
		this.is_host = is_host;
	}

	public Boolean getExist_flag() {
		return exist_flag;
	}

	public void setExist_flag(Boolean exist_flag) {
		this.exist_flag = exist_flag;
	}

}
