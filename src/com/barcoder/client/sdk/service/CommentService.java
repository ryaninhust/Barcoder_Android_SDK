package com.barcoder.client.sdk.service;

import java.util.List;

import org.apache.http.NameValuePair;

import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.Comment;
import com.barcoder.client.sdk.model.queryset.CommentQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.reflect.TypeToken;

public class CommentService extends BaseService {

	private static String commentsUrl=HttpHelper.host+"/activity/";
	
	public  String urlPattern(Integer activityID){
		return commentsUrl+activityID+"/activity/";
	}
	public ServiceListResult getComments(Integer activityID,List<NameValuePair> qparams){
		RestResult restResult=HttpHelper.doGET(urlPattern(activityID),true, HttpHelper.getLastModifiedDate(),  qparams);
		if(HttpHelper.checkRestResult(restResult)){
			return new ServiceListResult(getError(restResult),null);
		}
		else{
			List<CommentQuerySet> comments=getQuerySet(restResult);
			return new ServiceListResult(null,comments);
		}
	}
	private List<CommentQuerySet> getQuerySet(RestResult restResult) {
		return gson.fromJson(restResult.getResponseContent(), new TypeToken<List<CommentQuerySet>>() {
		}.getType());
	}
	public ServiceEntityResult addComment(Integer activityID,Comment comment){
		RestResult restResult=HttpHelper.doPOST(urlPattern(activityID), true, gson.toJson(comment));
		if(HttpHelper.checkRestResult(restResult)){
			return new ServiceEntityResult(getError(restResult), null);
		}
		else{
			return new ServiceEntityResult(null, getQuerySet(restResult).get(0));
		}
	}
	
}
