package com.barcoder.client.sdk.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.barcoder.client.sdk.model.result.RestResult;

public class HttpHelper {
	public static Date lastModified;

	public static final String host = "http://222.20.58.155:1080/";

	public static Boolean checkRestResult(RestResult result) {
		return result.getStatus_code() - 200 > 10;
	}

	public static RestResult doGET(String url, Boolean authRequest) {
		RestResult result = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);

		System.out.println(url);
		httpGet.addHeader("Accept", "application/json");
		httpGet.addHeader("Content-Type", "application/json");

		if (authRequest) {
			httpGet.addHeader("Authorization",
					AuthorizationHelper.getBasicAuthorization());
		}
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			HttpEntity responseEntity = httpResponse.getEntity();
			String content = ContentHelper.inputstreamToString(responseEntity
					.getContent());
			result = new RestResult(statusCode, content);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static RestResult doGET(String url, Boolean authRequest,
			Date conditionGet, List<NameValuePair> qparams) {
		RestResult result = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		if (qparams != null) {
			url = url + URLEncodedUtils.format(qparams, "UTF-8");
		}
		System.out.println(url);
		httpGet.addHeader("Accept", "application/json");
		httpGet.addHeader("Content-Type", "application/json");
		if (conditionGet != null) {
			httpGet.addHeader("If-Modified-Since", new SimpleDateFormat(
					"E, DD MM YYYY HH mm ss Z").format(conditionGet));

		}
		if (authRequest) {
			httpGet.addHeader("Authorization",
					AuthorizationHelper.getBasicAuthorization());
		}
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();
			HttpEntity responseEntity = httpResponse.getEntity();
			String content = ContentHelper.inputstreamToString(responseEntity
					.getContent());
			result = new RestResult(statusCode, content);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static RestResult doPOST(String url, Boolean authRequest,
			String postData) {
		RestResult result = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		try {
			StringEntity entity = new StringEntity(postData);
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-Type", "application/json");
			if (authRequest) {
				httpPost.setHeader("Authorization",
						AuthorizationHelper.getBasicAuthorization());
			}
			HttpResponse response = httpClient.execute(httpPost);
			Integer statusCode = response.getStatusLine().getStatusCode();
			String content = ContentHelper.inputstreamToString(response
					.getEntity().getContent());
			result = new RestResult(statusCode, content);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static RestResult doPUT(String url, Boolean authRequest,
			String postData) {
		RestResult result = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpPut httpPut = new HttpPut(url);
		httpPut.setHeader("Accept", "application/json");
		httpPut.setHeader("Content-Type", "application/json");
		if (authRequest) {
			httpPut.setHeader("Authorization",
					AuthorizationHelper.getBasicAuthorization());
		}
		try {
			httpPut.setEntity(new StringEntity(postData));
			HttpResponse httpResponse = httpClient.execute(httpPut);
			Integer statusCode = httpResponse.getStatusLine().getStatusCode();

			result = new RestResult(statusCode,
					ContentHelper.inputstreamToString(httpResponse.getEntity()
							.getContent()));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static RestResult doDelete(String url, Boolean authRequest) {
		RestResult result = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpDelete httpDelete = new HttpDelete();
		httpDelete.setHeader("Accept", "application/json");
		httpDelete.setHeader("Content-Type", "application/json");
		if (authRequest) {
			httpDelete.setHeader("Authorization",
					AuthorizationHelper.getBasicAuthorization());

		}
		try {
			HttpResponse response = httpClient.execute(httpDelete);
			Integer statusCode = response.getStatusLine().getStatusCode();
			result = new RestResult(statusCode,
					ContentHelper.inputstreamToString(response.getEntity()
							.getContent()));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static Date getLastModifiedDate() {
		if (lastModified == null) {
			return loadLastModifiedDate();
		} else {
			return lastModified;
		}
	}

	public static void setLastModifiedDate(Date date) {
		lastModified = date;

	}

	// 需要后期实现
	public static void saveLastModifiedDate() {

	}

	// 需要后期实现
	public static Date loadLastModifiedDate() {
		return new Date();
	}
}
