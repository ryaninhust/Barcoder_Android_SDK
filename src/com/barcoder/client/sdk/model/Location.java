package com.barcoder.client.sdk.model;

public class Location {
	private String name;
	private Float x;
	private Float y;
	private String description;
	private Boolean exist_flag;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getExist_flag() {
		return exist_flag;
	}

	public void setExist_flag(Boolean exist_flag) {
		this.exist_flag = exist_flag;
	}

}
