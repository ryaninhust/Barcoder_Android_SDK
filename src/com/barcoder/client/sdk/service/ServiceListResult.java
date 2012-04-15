package com.barcoder.client.sdk.service;

import java.util.List;

import com.barcoder.client.sdk.model.Error;

@SuppressWarnings("rawtypes")
public class ServiceListResult {
private Error error;


private List querySetModels;
public Error getError() {
	return error;
}
public void setError(Error error) {
	this.error = error;
}
public List getQuerySetModels() {
	return querySetModels;
}
public void setQuerySetModels(List querySetModels) {
	this.querySetModels = querySetModels;
}
public ServiceListResult(Error error, List querySetModels) {
	super();
	this.error = error;
	this.querySetModels = querySetModels;
}

}
