package com.example.testcouch;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.android.volley.VolleyError;

public class MainActivity extends Activity {

    public static final String TAG  = "TESTCOUCHE";
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.d( TAG , "START Activity"  );
        
        setContentView(R.layout.activity_main);
        
        ICommunication com = new SendData();
        DataBaseCommunication.sendPost( com );
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private class SendData implements ICommunication {
    	
    	private JSONObject obj;
    	private String url;
    	
    	public SendData( String url ){
    		this.url = url;
    	}
    	
    	public SendData(){
    		try {
				obj = new JSONObject("{name:toto,age:30}");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}

    	public String getUrl(){
    		return url;
    	}
    	
		@Override
		public void onErrorResponse(VolleyError error) {
			if( error.getMessage() != null ){
				Log.d( TAG , error.getMessage());
			}
			if( error.networkResponse != null ){
				Log.d( TAG , error.networkResponse.statusCode + "" );
			}
		}

		@Override
		public void onResponse(JSONObject arg0) {
			obj = arg0;
			Log.d(TAG, arg0.toString());
		}
		@Override
		public JSONObject getData() {
			return obj;
		}
    	
    }
    
}
