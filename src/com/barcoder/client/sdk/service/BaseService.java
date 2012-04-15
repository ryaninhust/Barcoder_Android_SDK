package com.barcoder.client.sdk.service;

import com.barcoder.client.sdk.model.Error;
import com.barcoder.client.sdk.model.result.RestResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseService {

	protected static Gson gson = new GsonBuilder().setDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss").create();

	public BaseService() {
		super();
	}

	/**
	 * @param restResult
	 * @return
	 */
	protected Error getError(RestResult restResult) {
		return gson.fromJson(
				restResult.getResponseContent(), Error.class);
	}

}