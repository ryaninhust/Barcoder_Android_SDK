package com.barcoder.client.sdk.service;

import java.util.List;

import org.apache.http.NameValuePair;

import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.queryset.ActivityQuerySet;
import com.barcoder.client.sdk.model.queryset.OrganizationQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.reflect.TypeToken;

public class OrganizationService extends BaseService {
	private String orgsUrl = HttpHelper.host + "/organizations/";
	private String orgUrl = HttpHelper.host + "/organization/";

	public String urlPattern(Integer organizationID, Integer activityID) {
		if (organizationID == null && activityID == null) {
			return orgsUrl;
		} else {
			if (activityID != null) {
				return orgUrl + organizationID + "/" + "activity" + activityID
						+ "/";
			} else {
				return orgUrl + organizationID + "/";
			}
		}
	}

	public ServiceListResult getOrganizationList(List<NameValuePair> qparams) {
		RestResult restResult = HttpHelper.doGET(urlPattern(null, null), false,
				null, qparams);
		if (HttpHelper.checkRestResult(restResult)) {
			return new ServiceListResult(getError(restResult), null);
		} else {
			List<OrganizationQuerySet> organizations = gson.fromJson(
					restResult.getResponseContent(),
					new TypeToken<List<OrganizationQuerySet>>() {
					}.getType());
			return new ServiceListResult(null, organizations);
		}

	}

	public ServiceListResult getOrganizationActivityList(Integer organizaionID,List<NameValuePair> qparams){
    	RestResult restResult=HttpHelper.doGET(urlPattern(organizaionID, null), false, null, qparams);
    	if (HttpHelper.checkRestResult(restResult)) {
    		return new ServiceListResult(getError(restResult),null );
			
		} else {
			List<ActivityQuerySet> activityQuerySets=gson.fromJson(restResult.getResponseContent(),new TypeToken<List<ActivityQuerySet>>(){}.getType());
			return new ServiceListResult(null, activityQuerySets);

		}
  
    }
//	public ServiceEntityResult getOrgAct(Integer organizaionId,Integer activityId){}
}
