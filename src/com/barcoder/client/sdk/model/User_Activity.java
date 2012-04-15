package com.barcoder.client.sdk.model;

import java.util.Date;

public class User_Activity {
	private Integer user;
	private Integer activity;
	private Integer part_level;
	private Integer rate;
	private Date joined_time;

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

	public Integer getPart_level() {
		return part_level;
	}

	public void setPart_level(Integer part_level) {
		this.part_level = part_level;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Date getJoined_time() {
		return joined_time;
	}

	public void setJoined_time(Date joined_time) {
		this.joined_time = joined_time;
	}

}
