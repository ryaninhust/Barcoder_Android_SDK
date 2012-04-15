package com.barcoder.client.sdk.model;

import java.util.Date;

public class Organization {
	private String name;
	private String description;
	private String url;
	private Date create_time;
	private Integer admin;
	private Boolean exist_flag;

	public Boolean getExist_flag() {
		return exist_flag;
	}

	public void setExist_flag(Boolean exist_flag) {
		this.exist_flag = exist_flag;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}



}
