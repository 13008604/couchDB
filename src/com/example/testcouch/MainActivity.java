package com.example.testcouch;

import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    public static final String TAG  = "TESTCOUCHE";
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d( TAG , "START Activity"  );
        
        setContentView(R.layout.activity_main);
        
        ICommunication com = new SendData();
        DataBaseCommunication.sendGet( com );
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private class SendData implements ICommunication {

    	public String getUrl(){
    		return "http://148.60.11.236:5984/test/97902d3a0d7974622f20deb3140000f1";
    	}
    	
		@Override
		public void onErrorResponse(VolleyError arg0) {
			Log.d( TAG , arg0.getMessage());
		}

		@Override
		public void onResponse(JSONObject arg0) {
			Log.d(TAG, arg0.toString());
		}
		@Override
		public JSONObject getData() {
			return null;
		}
    	
    }
    
}
