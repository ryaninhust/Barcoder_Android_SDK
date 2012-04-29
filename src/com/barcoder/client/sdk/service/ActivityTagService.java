package com.barcoder.client.sdk.service;

import java.util.List;

import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.Activitytag;
import com.barcoder.client.sdk.model.queryset.ActivitytagQuerySet;
import com.barcoder.client.sdk.model.queryset.Tag_ActivityQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.reflect.TypeToken;

public class ActivityTagService extends BaseService {

	private String UrlPattern(Integer activityID) {
		return HttpHelper.host + "/activity/" + activityID + "/tags/";

	}
	
    private List<ActivitytagQuerySet> getQuerySet(RestResult restResult){
    	return gson.fromJson(
				restResult.getResponseContent(),
				new TypeToken<List<ActivitytagQuerySet>>() {
				}.getType());
    }

	public ServiceListResult getTagList(Integer activityID) {
		RestResult restResult = HttpHelper.doGET(UrlPattern(activityID), false);
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceListResult(getError(restResult), null);
		} else {
            return new ServiceListResult(null, getQuerySet(restResult));
		}
	}
	
    public ServiceEntityResult addTag(Integer activityID,Activitytag activitytag){
    	RestResult restResult=HttpHelper.doPOST(UrlPattern(activityID), true, gson.toJson(activitytag));
    	if(HttpHelper.checkRestResult(restResult)){
    		return new ServiceEntityResult(getError(restResult), null);
    	}
    	else{
    		List<Tag_ActivityQuerySet> list=gson.fromJson(restResult.getResponseContent(), new TypeToken<List<Tag_ActivityQuerySet>>(){}.getType());
    		return new ServiceEntityResult(null, list.get(0));
    	}
    }
			
}
