package com.barcoder.client.sdk.model.queryset;

import com.barcoder.client.sdk.model.User;

public class UserQuerySet extends QuerySetModel {
public User fields;

public User getFields() {
	return fields;
}

public void setFields(User fields) {
	this.fields = fields;
}

}
