package com.barcoder.client.sdk.model;

import java.util.Date;

public class Comment {
private Integer activity;
private Integer user;
private String comment_content;
private Date comment_date;
private Boolean exist_flag;
public Integer getActivity() {
	return activity;
}
public void setActivity(Integer activity) {
	this.activity = activity;
}
public Integer getUser() {
	return user;
}
public void setUser(Integer user) {
	this.user = user;
}
public String getComment_content() {
	return comment_content;
}
public void setComment_content(String comment_content) {
	this.comment_content = comment_content;
}
public Date getComment_date() {
	return comment_date;
}
public void setComment_date(Date comment_date) {
	this.comment_date = comment_date;
}
public Boolean getExist_flag() {
	return exist_flag;
}
public void setExist_flag(Boolean exist_flag) {
	this.exist_flag = exist_flag;
}

}
