package com.barcoder.client.sdk.service;

import java.util.List;

import org.apache.http.NameValuePair;



import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.Activity;
import com.barcoder.client.sdk.model.queryset.ActivityQuerySet;
import com.barcoder.client.sdk.model.queryset.UserQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.reflect.TypeToken;

public class ActivityService extends BaseService {

	private static String activitiesUrl = HttpHelper.host + "/activities/";
	private static String activityUrl = HttpHelper.host + "/activity/";

	private static ActivityQuerySet getSingleResult(List<ActivityQuerySet> list) {
		return list.get(0);
	}

	public ServiceListResult getActivities(List<NameValuePair> qparams) {
		RestResult restResult = HttpHelper.doGET(activitiesUrl, false,
				HttpHelper.getLastModifiedDate(), qparams);
		if (HttpHelper.checkRestResult(restResult)) {
			com.barcoder.client.sdk.model.Error error = getError(restResult);

			return new ServiceListResult(error, null);
		} else {
			List<ActivityQuerySet> list = getQuerySet(restResult);

			return new ServiceListResult(null, list);
		}
	}

	public ServiceEntityResult addActity(Activity activity) {
		RestResult restResult = HttpHelper.doPOST(activitiesUrl, true,
				gson.toJson(activity));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<ActivityQuerySet> list = getQuerySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(list));
		}
	}

	public ServiceEntityResult editActivity(Integer pk, Activity activity) {
		RestResult restResult = HttpHelper.doPUT(activityUrl+pk+"/", true,
				gson.toJson(activity));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<ActivityQuerySet> list = getQuerySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(list));
		}
	}

	/**
	 * @param restResult
	 * @return
	 */
	private List<ActivityQuerySet> getQuerySet(RestResult restResult) {
		return gson.fromJson(
				restResult.getResponseContent(),
				new TypeToken<List<UserQuerySet>>() {
				}.getType());
	}

	public ServiceBoolResult deleteActivity(Integer pk){
		RestResult restResult=HttpHelper.doDelete(activityUrl+pk+"/", true);
		if (HttpHelper.checkRestResult(restResult)){
			return new ServiceBoolResult(getError(restResult), false);
		}
		else{
			return new ServiceBoolResult(null, true);
		}
	}
}
