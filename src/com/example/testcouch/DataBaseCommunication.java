package com.example.testcouch;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

public class DataBaseCommunication {
	
	public static final String BASE_URL = "http://148.60.11.236:5984/sitac/";
	
	public static void sendGet(ICommunication com){
		send(com, Request.Method.GET);
	}
	
	public static void sendPost(ICommunication com ){
		send(com, Request.Method.POST);
	}
	
	private static void send( ICommunication com, int method ){
		VolleySingleton v = VolleySingleton.getInstance();
		RequestQueue rq = v.getRequestQueue();
		
		Log.i("SITAC - URL", com.getUrl() );
		if( com.getData() != null ){
			Log.i("SITAC - GET - DATA", com.getData().toString());
		}	
		
		JsonObjectRequest request = new JsonObjectRequest(
					method,
					com.getUrl(),
					com.getData(), com, com);
		
		rq.add(request);
	}
	
}
