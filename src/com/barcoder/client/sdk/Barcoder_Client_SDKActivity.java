package com.barcoder.client.sdk;

import java.util.Date;
import java.util.List;

import com.barcoder.client.sdk.helper.HttpHelper;
import com.barcoder.client.sdk.model.User;
import com.barcoder.client.sdk.model.queryset.ActivityQuerySet;
import com.barcoder.client.sdk.model.queryset.QuerySetModel;
import com.barcoder.client.sdk.model.queryset.UserQuerySet;
import com.barcoder.client.sdk.model.result.RestResult;
import com.barcoder.client.sdk.service.ServiceEntityResult;
import com.barcoder.client.sdk.service.UserAccountService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.os.Bundle;


public class Barcoder_Client_SDKActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        User user=new User();
        user.setName("fuck");
        UserQuerySet userQuerySet=new UserQuerySet();
        userQuerySet.setPk(1);
        userQuerySet.setModel("asdad");
        userQuerySet.setFields(user);
        

        
        
  
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        setContentView(R.layout.main);
        
        
        System.out.println(gson.toJson(userQuerySet));
        UserQuerySet quer11= gson.fromJson(gson.toJson(userQuerySet), UserQuerySet.class);
        User querySetModel3= quer11.getFields();
        System.out.println(querySetModel3.getName());
        RestResult result=  HttpHelper.doGET("http://222.20.58.155:1080/activity/1/", false);
        System.out.println(result.getStatus_code());
        System.out.println(result.getResponseContent());
        
        List<ActivityQuerySet> activity2=gson.fromJson(result.getResponseContent(),new TypeToken<List<ActivityQuerySet>>(){}.getType());
        ServiceEntityResult serviceResult=new ServiceEntityResult(null, activity2.get(0));
        
        com.barcoder.client.sdk.model.Activity activity=activity2.get(0).getFields();
        System.out.println(activity.getEmail());
        System.out.println(serviceResult.getQuerySetModel().getModel());
        UserAccountService service=new UserAccountService();
        ServiceEntityResult result4=service.getUser(1);
        System.out.println(result4.getQuerySetModel().getModel());
        service.deleteUser(1);
        
        
        
    }
}