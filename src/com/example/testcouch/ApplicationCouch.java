package com.example.testcouch;

import android.app.Application;
import android.content.Context;

public class ApplicationCouch extends Application {

	private static Context contextApplication;

	@Override
	public void onCreate() {
		super.onCreate();
		contextApplication = this.getApplicationContext();
	}
	
	public static Context getApplicationCouchContext()
	{
		return ApplicationCouch.contextApplication;
	}
	
}
