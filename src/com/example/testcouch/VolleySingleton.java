package com.example.testcouch;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {

	private static VolleySingleton volley;
	
	private RequestQueue mRequestQueue;
	
	private VolleySingleton( Context context ) {
		mRequestQueue = Volley.newRequestQueue(context);
	}
	
	public static VolleySingleton getInstance()
	{
		if( volley == null ){ volley = new VolleySingleton( ApplicationCouch.getApplicationCouchContext()); }
		return volley;
	}
	
	public RequestQueue getRequestQueue(){
		return mRequestQueue;
	}
	
}
