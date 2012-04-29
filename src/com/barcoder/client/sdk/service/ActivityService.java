package com.barcoder.client.sdk.service;

import java.util.List;

import org.apache.http.NameValuePair;



import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.Activity;
import com.barcoder.client.sdk.model.queryset.ActivityQuerySet;
import com.barcoder.client.sdk.model.queryset.UserQuerySet;
import com.barcoder.client.sdk.model.queryset.User_ActivityQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.reflect.TypeToken;

public class ActivityService extends BaseService {

	private static String activitiesUrl = HttpHelper.host + "/activities/";
	private static String activityUrl = HttpHelper.host + "/activity/";
	
	
	

	private  String urlPattern(Integer activityID,Boolean users) {
		// TODO Auto-generated method stub
		if (users){
			return activityUrl+activityID+"/"+"users";
		}
		return activityUrl+activityID+"/";
	}
	private String urlPattern(Integer activityID,Integer userID){
		return activityUrl+activityID+"/"+"user"+userID+"/";
	}
   
	

	private static ActivityQuerySet getSingleResult(List<ActivityQuerySet> list) {
		return list.get(0);
	}
	private static User_ActivityQuerySet getSingleResult(List<User_ActivityQuerySet> list){
		return list.get(0);
	}

	public ServiceListResult getActivities(List<NameValuePair> qparams) {
		RestResult restResult = HttpHelper.doGET(activitiesUrl, false,
				HttpHelper.getLastModifiedDate(), qparams);
		if (HttpHelper.checkRestResult(restResult)) {
			com.barcoder.client.sdk.model.Error error = getError(restResult);

			return new ServiceListResult(error, null);
		} else {
			List<ActivityQuerySet> list = getActivitySet(restResult);

			return new ServiceListResult(null, list);
		}
	}

	public ServiceEntityResult addActity(Activity activity) {
		RestResult restResult = HttpHelper.doPOST(activitiesUrl, true,
				gson.toJson(activity));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<ActivityQuerySet> list = getActivitySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(list));
		}
	}

	public ServiceEntityResult editActivity(Integer pk, Activity activity) {
		RestResult restResult = HttpHelper.doPUT(activityUrl+pk+"/", true,
				gson.toJson(activity));
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceEntityResult(getError(restResult), null);
		} else {
			List<ActivityQuerySet> list = getActivitySet(restResult);
			return new ServiceEntityResult(null, getSingleResult(list));
		}
	}

	/**
	 * @param restResult
	 * @return
	 */
	private List<ActivityQuerySet> getActivitySet(RestResult restResult) {
		return gson.fromJson(
				restResult.getResponseContent(),
				new TypeToken<List<ActivityQuerySet>>() {
				}.getType());
	}
	private List<UserQuerySet> getActUserQuerySet(RestResult restResult){
		return gson.fromJson(
				restResult.getResponseContent(),
				new TypeToken<List<UserQuerySet>>() {
				}.getType());
	}
	private List<User_ActivityQuerySet> getUser_ActivityQuerySet(RestResult restResult){
		return gson.fromJson(
				restResult.getResponseContent(),
				new TypeToken<List<User_ActivityQuerySet>>() {
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
	public ServiceListResult getActivityUsers(Integer pk){
		RestResult restResult =HttpHelper.doGET(urlPattern(pk, true), false);
		if(HttpHelper.checkRestResult(restResult)){
			return new  ServiceListResult(getError(restResult),null);
		}
		else{
			return new ServiceListResult(null, getActUserQuerySet(restResult));
		}
		
	}
	public ServiceEntityResult getActivityUser(Integer activityID,Integer userID){
		RestResult restResult=HttpHelper.doGET(urlPattern(activityID, userID), false);
		if (HttpHelper.checkRestResult(restResult)){
			return new ServiceEntityResult(getError(restResult), null);
		}
		else{
			return new ServiceEntityResult(null, getSingleResult(getUser_ActivityQuerySet(restResult)));
		}
	}
	public ServiceEntityResult editActivityUser(Integer activityID,Integer userID,User_ActivityQuerySet uQuerySet){
		RestResult restResult=HttpHelper.doPUT(urlPattern(activityID, userID), true, gson.toJson(uQuerySet));
		if (HttpHelper.checkRestResult(restResult)){
			return new ServiceEntityResult(getError(restResult), null);
		}
		else{
			return new ServiceEntityResult(null, getSingleResult(getUser_ActivityQuerySet(restResult)));
		}
	}
}
