package com.barcoder.client.sdk.model.result;

import java.util.Date;

public class RestResult {
private Integer status_code;
private String  responseContent;
private Date LastModified; 
public Integer getStatus_code() {
	return status_code;
}
public void setStatus_code(Integer status_code) {
	this.status_code = status_code;
}
public Date getLastModified() {
	return LastModified;
}
public void setLastModified(Date lastModified) {
	LastModified = lastModified;
}
public String getResponseContent() {
	return responseContent;
}
public void setResponseContent(String responseContent) {
	this.responseContent = responseContent;
}
public RestResult(Integer status_code, String responseContent) {
	super();
	this.status_code = status_code;
	this.responseContent = responseContent;
}
public RestResult(Integer status_code, String responseContent, Date lastModified) {
	super();
	this.status_code = status_code;
	this.responseContent = responseContent;
	LastModified = lastModified;
}


}
