package com.barcoder.client.sdk.service;

import java.util.List;

import org.apache.http.NameValuePair;

import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.Activity;
import com.barcoder.client.sdk.model.User_Activity;
import com.barcoder.client.sdk.model.queryset.User_ActivityQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.reflect.TypeToken;

public class UserActivityService extends BaseService {
	private String uaUrl = HttpHelper.host + "/user/";

	private String urlPattern(Integer userId, Integer activityID) {
		if (activityID == null) {
			return uaUrl + userId + "/activities/";
		} else {
			return uaUrl + userId + "/activity/" + activityID;
		}
	}

	public ServiceListResult getUserActivities(Integer userID,
			List<NameValuePair> qparams) {
		RestResult restResult = HttpHelper.doGET(urlPattern(userID, null),
				true, null, qparams);
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceListResult(getError(restResult), null);
		} else {
			List<Activity> activities = gson.fromJson(
					restResult.getResponseContent(),
					new TypeToken<List<Activity>>() {
					}.getType());
			return new ServiceListResult(null, activities);
		}

	}

	public ServiceEntityResult addUserActivity(Integer userID,
			User_Activity user_Activity) {
		RestResult restResult = HttpHelper.doPOST(urlPattern(userID, null),
				true, gson.toJson(user_Activity));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<User_ActivityQuerySet> user_ActivityQuerySets = gson.fromJson(
					restResult.getResponseContent(),
					new TypeToken<List<User_ActivityQuerySet>>() {
					}.getType());
			return new ServiceEntityResult(null, user_ActivityQuerySets.get(0));
		}

	}

	public ServiceEntityResult getUserActivity(Integer userID,
			Integer activityID, List<NameValuePair> qparams) {
		RestResult restResult = HttpHelper.doGET(urlPattern(userID, userID),
				true, null, qparams);
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<User_ActivityQuerySet> user_ActivityQuerySets = gson.fromJson(
					restResult.getResponseContent(),
					new TypeToken<List<User_ActivityQuerySet>>() {
					}.getType());
			return new ServiceEntityResult(null, user_ActivityQuerySets.get(0));
		}
	}

	public ServiceEntityResult editUserActivity(Integer userID,
			Integer activityID, User_Activity user_Activity) {
		RestResult restResult = HttpHelper.doPUT(
				urlPattern(userID, activityID), true,
				gson.toJson(user_Activity));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<User_ActivityQuerySet> list = gson.fromJson(
					restResult.getResponseContent(),
					new TypeToken<List<User_ActivityQuerySet>>() {
					}.getType());
			return new ServiceEntityResult(null, list.get(0));
		}
	}

}
