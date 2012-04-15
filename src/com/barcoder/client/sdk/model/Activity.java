package com.barcoder.client.sdk.model;

import java.util.Date;

public class Activity {
	private String name;
	private String description;
	private Date b_date;
	private Date f_date;
	private String addr;
	private Integer barcoder;
	private Integer location;
	private Date timestamp;
	private String url;
	private String email;
	private String phone;
	private Boolean exist_flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public Date getF_date() {
		return f_date;
	}

	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getBarcoder() {
		return barcoder;
	}

	public void setBarcoder(Integer barcoder) {
		this.barcoder = barcoder;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getExist_flag() {
		return exist_flag;
	}

	public void setExist_flag(Boolean exist_flag) {
		this.exist_flag = exist_flag;
	}

}
