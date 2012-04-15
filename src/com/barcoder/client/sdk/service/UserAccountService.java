package com.barcoder.client.sdk.service;

import java.util.List;

import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.User;
import com.barcoder.client.sdk.model.queryset.UserQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;

import com.google.gson.reflect.TypeToken;

public class UserAccountService  extends BaseService{

	private static String usersUrl = HttpHelper.host + "/users/";
	private static String userUrl = HttpHelper.host + "/user/";


	private static UserQuerySet getSingleResult(List<UserQuerySet> list) {
		return list.get(0);
	}

	public ServiceEntityResult addUser(User user) {
		RestResult restResult = HttpHelper.doPOST(usersUrl, false,
				gson.toJson(user));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<UserQuerySet> users = getQuerySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(users));
		}
	}

	private List<UserQuerySet> getQuerySet(RestResult restResult) {
		return gson.fromJson(
				restResult.getResponseContent(),
				new TypeToken<List<UserQuerySet>>() {
				}.getType());
	}



	public ServiceEntityResult getUser(Integer pk) {
		RestResult restResult = HttpHelper.doGET(userUrl + pk + "/", false);
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<UserQuerySet> users = getQuerySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(users));
		}

	}

	public ServiceEntityResult editUser(Integer pk, User user) {
		RestResult restResult = HttpHelper.doPUT(userUrl + pk + "/", true,
				gson.toJson(user));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<UserQuerySet> users = getQuerySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(users));
		}
	}

	public ServiceBoolResult deleteUser(Integer pk) {
		RestResult restResult = HttpHelper.doDelete(userUrl + pk + "/", true
				);
		if (HttpHelper.checkRestResult(restResult)){
			return new ServiceBoolResult(getError(restResult), false);
			
		}
		else{

			return new ServiceBoolResult(null,false);
		}

	}
}
