package com.barcoder.client.sdk.service;

import com.barcoder.client.sdk.model.Error;

public class ServiceBoolResult {
private  com.barcoder.client.sdk.model.Error error;
private Boolean Result;
public Error getError() {
	return error;
}
public void setError(Error error) {
	this.error = error;
}
public Boolean getResult() {
	return Result;
}
public void setResult(Boolean result) {
	Result = result;
}
public ServiceBoolResult(Error error, Boolean result) {
	super();
	this.error = error;
	Result = result;
}

}
