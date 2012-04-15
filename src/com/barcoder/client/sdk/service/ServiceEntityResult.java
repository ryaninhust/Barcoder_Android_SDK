package com.barcoder.client.sdk.service;

import com.barcoder.client.sdk.model.Error;
import com.barcoder.client.sdk.model.queryset.QuerySetModel;

public class ServiceEntityResult {
	
private Error error;

private QuerySetModel querySetModel;



public ServiceEntityResult(Error error, QuerySetModel querySetModel) {
	super();
	this.error = error;
	this.querySetModel = querySetModel;
}
public Error getError() {
	return error;
}
public void setError(Error error) {
	this.error = error;
}
public QuerySetModel getQuerySetModel() {
	return querySetModel;
}
public void setQuerySetModel(QuerySetModel querySetModel) {
	this.querySetModel = querySetModel;
}

}
